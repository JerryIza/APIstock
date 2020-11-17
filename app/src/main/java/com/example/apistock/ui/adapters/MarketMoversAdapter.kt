package com.example.apistock.ui.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.example.apistock.R
import com.example.apistock.data.entities.MarketMovers
import com.example.apistock.databinding.MoversListBinding
import kotlinx.coroutines.withContext

class MarketMoversAdapter(
    private val inputs: ArrayList<MarketMovers>,
    private val listener: (Int) -> Unit
) :
    RecyclerView.Adapter<MoversViewHolder>() {

    fun setItems(inputs: ArrayList<MarketMovers>) {
        this.inputs.clear()
        this.inputs.addAll(inputs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoversViewHolder {
        val binding: MoversListBinding =
            MoversListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoversViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoversViewHolder, position: Int) =
        holder.bind(inputs[position], position, listener)


    override fun getItemCount() = inputs.size

}

class MoversViewHolder(private val itemBinding: MoversListBinding) : RecyclerView.ViewHolder(
    itemBinding.root
) {
    fun bind(result: MarketMovers, pos: Int, listener: (Int) -> Unit) {
        val regex = Regex(pattern = "-")
        itemBinding.moversSymbol.text = result.symbol
        itemBinding.moversDescription.text = result.description
        itemBinding.moversDirection.text = (result.direction)
        itemBinding.moversLast.text = ("Last: ${result.last}")
        itemBinding.moversChange.text = if (regex.containsMatchIn(result.change.toString())) {
            itemBinding.moversChange.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.colorDown))
            itemBinding.moversDirection.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.colorDown))
            ("Change: " + ("%,.3f".format(result.change * 100)) + "%")
        } else {
            itemBinding.moversChange.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.colorUp))
            itemBinding.moversDirection.setTextColor(ContextCompat.getColor(this.itemView.context, R.color.colorUp))
            ("Change: " + ("%,.3f".format(result.change * 100)) + "%")
        }
        itemBinding.moversVolume.text = ("Volume: ${("%,d".format(result.totalVolume))}")
        itemView.setOnClickListener { listener(pos) }
    }
}