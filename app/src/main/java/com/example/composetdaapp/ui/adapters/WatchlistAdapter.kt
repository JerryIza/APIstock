package com.example.composetdaapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.R
import com.example.composetdaapp.databinding.WatchlistListBinding


class WatchlistAdapter(
    private val inputs: ArrayList<SymbolDetails>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<WatchlistViewHolder>() {


    //TODO Before passing data to adaptor, sort using Comparator
    fun setItems(inputs: MutableCollection<SymbolDetails>) {
        this.inputs.clear()
        this.inputs.addAll(inputs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistViewHolder {
        val binding: WatchlistListBinding =
            WatchlistListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WatchlistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WatchlistViewHolder, position: Int) =
        holder.bind(inputs[position], position, listener)


    override fun getItemCount() = inputs.size

}

class WatchlistViewHolder(private val itemBinding: WatchlistListBinding) : RecyclerView.ViewHolder(
    itemBinding.root
) {
    //maybe not watchlist but instrument we bind?
    //make val to summerize results?????
    fun bind(result: SymbolDetails, pos: Int, listener: (Int) -> Unit) {

        val regex = Regex(pattern = "-")
        itemBinding.wlSymbol.text = result.symbol
        itemBinding.wlDescription.text = result.description
        itemBinding.wlLast.text = ("$%,.2f".format(result.mark))
        //not ready yet, will add with watchlist
        itemBinding.wlNetChange.text = ("%,.2f".format(result.markChangeInDouble) + " (" + "%,.2f".format(result.markPercentChangeInDouble) + "%)")


        when {
            regex.containsMatchIn(result.regularMarketNetChange.toString()) -> {
                itemBinding.wlNetChange.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.colorDown))
                ("%,.2f".format(result.markChangeInDouble) + " (" +"%,.2f".format(result.markPercentChangeInDouble)) + "%)"
            }
            result.regularMarketNetChange != 0.0 -> {
                itemBinding.wlNetChange.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.colorUp))
                itemBinding.wlNetChange.text =  ("%,.2f".format(result.markChangeInDouble) + " (" +"%,.2f".format(result.markPercentChangeInDouble)) + "%)"
            }
            else -> {
                itemBinding.wlNetChange.text =  ("%,.2f".format(result.markChangeInDouble) + " (" +"%,.2f".format(result.markPercentChangeInDouble)) + "%)"
            }
        }


        //itemBinding.moversVolume.text = ("Volume: ${("%,d".format(result.totalVolume))}")
        itemView.setOnClickListener { listener(pos) }
    }
}