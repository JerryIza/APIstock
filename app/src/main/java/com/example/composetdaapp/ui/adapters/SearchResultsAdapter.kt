package com.example.composetdaapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.composetdaapp.data.entities.quotes.SymbolSearch
import com.example.composetdaapp.databinding.SearchListBinding

class SearchResultsAdapter(
    private val inputs: ArrayList<SymbolSearch>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<SearchViewHolder>() {

    fun setItems(inputs: ArrayList<SymbolSearch>) {
        this.inputs.clear()
        this.inputs.addAll(inputs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding: SearchListBinding = SearchListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) =
        holder.bind(inputs[position], position, listener)
    override fun getItemCount() = inputs.size
}

class SearchViewHolder(private val itemBinding: SearchListBinding) : RecyclerView.ViewHolder(
    itemBinding.root
) {
    fun bind(result: SymbolSearch, pos: Int, listener: (Int) -> Unit) {
        itemBinding.sSymbolTv.text = result.symbol
        itemBinding.sDescriptionTv.text = result.description

        itemView.setOnClickListener { listener(pos) }
    }
}