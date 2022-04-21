package com.example.composetdaapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.composetdaapp.data.entities.orders.get.GetOrderItem
import com.example.composetdaapp.databinding.OrdersListBinding

class OrdersAdapter(
    private val inputs: ArrayList<GetOrderItem>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<OrdersViewHolder>() {

    fun setItems(inputs: List<GetOrderItem>?) {
        this.inputs.clear()
        inputs?.let { this.inputs.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val binding: OrdersListBinding =
            OrdersListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrdersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) =
        holder.bind(inputs[position], position, listener)

    //exclude Money Market from list, what if account is flagged as PTD?
    override fun getItemCount() = inputs.size

}

class OrdersViewHolder(private val itemBinding: OrdersListBinding) : RecyclerView.ViewHolder(
    itemBinding.root
) {
    fun bind(result: GetOrderItem, pos: Int, listener: (Int) -> Unit) {
        itemBinding.oTime.text = result.enteredTime
        itemBinding.oSymbol.text = result.orderLegCollection[pos].instrument.symbol
        itemBinding.oSpread.text = result.orderStrategyType
        itemBinding.oSide.text = result.orderType
        itemBinding.oEffect.text = result.orderType
        itemBinding.oStatus.text = result.status
        itemBinding.oTif.text = result.session


        itemView.setOnClickListener { listener(pos) }
    }
}