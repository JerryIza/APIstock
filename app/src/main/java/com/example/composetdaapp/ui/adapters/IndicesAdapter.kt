package com.example.composetdaapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.composetdaapp.data.entities.websocket.response.Content
import com.example.composetdaapp.R
import com.example.composetdaapp.databinding.IndicesListBinding

class IndicesAdapter(
    private val inputs: ArrayList<Pair<String, Content>>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<IndicesViewHolder>() {


    fun setItems(inputs: MutableMap<String, Content>) {
        this.inputs.clear()
        this.inputs.addAll(inputs.map { it.key to it.value })
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicesViewHolder {
        val binding: IndicesListBinding =
            IndicesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IndicesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IndicesViewHolder, position: Int) =
        holder.bind(inputs[position], position, listener)


    override fun getItemCount() = inputs.size

}

class IndicesViewHolder(private val itemBinding: IndicesListBinding) : RecyclerView.ViewHolder(
    itemBinding.root
) {
    fun bind(result: Pair<String, Content>, pos: Int, listener: (Int) -> Unit) {
        println("RESULTS null" + result)


        if (result != null) {
            println("RESULTS " + result)
            val futPercent = result.second.futPcChange?.times(100)
            val regex = Regex(pattern = "-")
            itemBinding.iSymbol.text = result.first.toString()
            itemBinding.iLast.text = ("$%,.2f".format(result.second.futLast))
            itemBinding.iChg.text =
                ("%,.2f".format(result.second.futNetChange) + " (" + "%,.2f".format(futPercent) + "%)")


            if (regex.containsMatchIn(result.second.futNetChange.toString())) {
                itemBinding.iChg.setTextColor(
                    ContextCompat.getColor(
                        this.itemView.context,
                        R.color.colorDown
                    )
                )
                ("%,.2f".format(result.second.futNetChange) + " (" + "%,.2f".format(result.second.futPcChange)) + "%)"
            } else if (result.second.futNetChange != 0.0) {
                itemBinding.iChg.setTextColor(
                    ContextCompat.getColor(
                        this.itemView.context,
                        R.color.colorUp
                    )
                )
                itemBinding.iChg.text =
                    ("%,.2f".format(result.second.futNetChange) + " (" + "%,.2f".format(futPercent)) + "%)"
            } else {
                itemBinding.iChg.text =
                    ("%,.2f".format(result.second.futNetChange) + " (" + "%,.2f".format(futPercent)) + "%)"
            }


            itemView.setOnClickListener { listener(pos) }
        }
    }
}
