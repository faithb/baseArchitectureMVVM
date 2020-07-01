package com.example.basearchitecturemvvm.ui.statistics

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basearchitecturemvvm.R
import com.example.basearchitecturemvvm.model.Fruit
import com.example.basearchitecturemvvm.model.FruitClassFication
import kotlinx.android.synthetic.main.item_fruit.view.*
import kotlinx.android.synthetic.main.item_fruit.view.tvName
import kotlinx.android.synthetic.main.item_fruit.view.tvPrice
import kotlinx.android.synthetic.main.item_fruit_class_fication.view.*

/**
 * Created by HungTran.V on 2020-07-01.
 */
class FruitClassFicationAdapter (val fruits: MutableList<FruitClassFication>) :
    RecyclerView.Adapter<FruitClassFicationAdapter.FruitClassFicationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitClassFicationViewHolder {
        return FruitClassFicationViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_fruit_class_fication,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FruitClassFicationViewHolder, position: Int) {
        holder.bind(fruits[position])
    }

    override fun getItemCount(): Int = fruits.size

    inner class FruitClassFicationViewHolder(itemView: View, onclickItem: ((position: Int) -> Unit)? = null) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(fruit: FruitClassFication) {
            itemView.apply {
                tvName.text = fruit.nameFruit
                tvAmount.text = fruit.amount
                tvPrice.text = fruit.price
            }
        }
    }
}
