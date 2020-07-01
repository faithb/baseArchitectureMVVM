package com.example.basearchitecturemvvm.ui.detail

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basearchitecturemvvm.R
import com.example.basearchitecturemvvm.model.Fruit
import kotlinx.android.synthetic.main.item_fruit.view.*

/**
 * Created by HungTran.V on 2020-07-01.
 */
class FruitAdapter (val fruits: MutableList<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        return FruitViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_fruit,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bind(fruits[position])
    }

    override fun getItemCount(): Int = fruits.size

    inner class FruitViewHolder(itemView: View, onItemArticleClick: ((position: Int) -> Unit)? = null) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(fruit: Fruit) {
            itemView.apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imgFruit.setImageDrawable(context.getDrawable(fruit.image))
                }
                tvName.text = fruit.name
                tvPrice.text = fruit.price
            }
        }
    }
}
