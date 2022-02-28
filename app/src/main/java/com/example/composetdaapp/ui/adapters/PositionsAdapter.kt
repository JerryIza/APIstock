package com.example.composetdaapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.composetdaapp.data.entities.account.Positions
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.R
import com.example.composetdaapp.databinding.PositionsListBinding

    class PositionsAdapter(
    private val inputs: ArrayList<Pair<Positions, SymbolDetails>>,
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<PositionViewHolder>() {

    fun setItems(inputs: MutableMap<Positions, SymbolDetails>) {
        this.inputs.clear()
        this.inputs.addAll((inputs.map { it.key to it.value }))
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        val binding: PositionsListBinding =
            PositionsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PositionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) =
        holder.bind(inputs[position], position, listener)

    //exclude Money Market from list, what if account is flagged as PTD?
    override fun getItemCount() = inputs.size

}

class PositionViewHolder(private val itemBinding: PositionsListBinding) : RecyclerView.ViewHolder(
    itemBinding.root
) {
    fun bind(result: Pair<Positions, SymbolDetails>, pos: Int, listener: (Int) -> Unit) {
        val positionData = result.first
        val symbolDetails = result.second
        //for some reason position endpoint only has Daily gain but not P/L Gain Overall.
        val posGain = (symbolDetails.lastPrice - positionData.averagePrice) * positionData.longQuantity
        val regex = Regex(pattern = "-")
        itemBinding.pSymbol.text = positionData.instrument.symbol
        itemBinding.pDescription.text = symbolDetails.description
        itemBinding.pLChg.text = ("P/L Day: " + ("$%,.2f".format(positionData.currentDayProfitLoss)))
        itemBinding.pCost.text = ("Avg C: " + ("$%,.2f".format(positionData.averagePrice)))
        itemBinding.pLast.text = ("Last: " + ("$%,.2f".format(symbolDetails.lastPrice)))
        itemBinding.pMaint.text = ("MaintReq: " + ("%,.2f".format(positionData.maintenanceRequirement)))
        itemBinding.pChg.text = (("%,.2f".format(symbolDetails.markChangeInDouble) + " (" + "%,.2f".format(symbolDetails.markPercentChangeInDouble)) + "%)")
        //itemBinding.pChg.text = ("%,. 2f".format(symbolDetails))
        if (positionData.shortQuantity < 0) {
            itemBinding.pQuantity.text = ("Qty: " + "-" + positionData.shortQuantity.toString())
            itemBinding.pLOpen.text =
                ("P/L Open: " + ("$%,.2f".format((positionData.averagePrice - symbolDetails.lastPrice) * positionData.shortQuantity)))
        } else {
            itemBinding.pQuantity.text = ("Qty: " + positionData.longQuantity.toString())
            itemBinding.pLOpen.text =
                ("P/L Open: " + ("$%,.2f".format(posGain)))
        }
        //P/L Overall Gain
        when {
            regex.containsMatchIn(posGain.toString()) -> {
                itemBinding.pLOpen.setTextColor(
                    ContextCompat.getColor(
                        this.itemView.context,
                        R.color.colorDown
                    )
                )

            }
            posGain != 0.0 -> {
                itemBinding.pLOpen.setTextColor(
                    ContextCompat.getColor(
                        this.itemView.context,
                        R.color.colorUp
                    )
                )

            }

        }

        //net change and p/l day
        when {
            regex.containsMatchIn(symbolDetails.regularMarketNetChange.toString()) -> {
                itemBinding.pChg.setTextColor(
                    ContextCompat.getColor(
                        this.itemView.context,
                        R.color.colorDown
                    )
                )
                itemBinding.pLChg.setTextColor(
                    ContextCompat.getColor(
                        this.itemView.context,
                        R.color.colorDown
                    )
                )

            }
            symbolDetails.regularMarketNetChange != 0.0 -> {
                itemBinding.pChg.setTextColor(
                    ContextCompat.getColor(
                        this.itemView.context,
                        R.color.colorUp
                    )
                )
                itemBinding.pLChg.setTextColor(
                    ContextCompat.getColor(
                        this.itemView.context,
                        R.color.colorUp
                    )
                )


            }
            else -> {

            }
        }

        itemView.setOnClickListener { listener(pos) }
    }
}