package com.example.apistock.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.apistock.R
import com.example.apistock.data.entities.quotes.SymbolDetails

import com.example.apistock.databinding.WatchlistListBinding

class WatchlistAdapter(
    private val inputs: ArrayList<SymbolDetails>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<WatchlistViewHolder>() {



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
        itemBinding.wlLast.text = ("$%,.2f".format(result.lastPrice))
        //not ready yet, will add with watchlist
        itemBinding.wlNetChange.text = ("%,.2f".format(result.markChangeInDouble) + " (" + "%,.2f".format(result.markPercentChangeInDouble) + "%)")


         if (regex.containsMatchIn(result.regularMarketNetChange.toString())) {
            itemBinding.wlNetChange.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.colorDown))
            ("%,.2f".format(result.markChangeInDouble) + " (" +"%,.2f".format(result.markPercentChangeInDouble)) + "%)"
        } else if (result.regularMarketNetChange != 0.0) {
            itemBinding.wlNetChange.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.colorUp))
            itemBinding.wlNetChange.text =  ("%,.2f".format(result.markChangeInDouble) + " (" +"%,.2f".format(result.markPercentChangeInDouble)) + "%)"
        }else{
             itemBinding.wlNetChange.text =  ("%,.2f".format(result.markChangeInDouble) + " (" +"%,.2f".format(result.markPercentChangeInDouble)) + "%)"
         }


        //itemBinding.moversVolume.text = ("Volume: ${("%,d".format(result.totalVolume))}")
        itemView.setOnClickListener { listener(pos) }
    }
}