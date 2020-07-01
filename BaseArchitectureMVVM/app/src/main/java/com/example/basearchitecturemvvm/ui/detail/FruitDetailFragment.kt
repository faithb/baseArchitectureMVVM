package com.example.basearchitecturemvvm.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basearchitecturemvvm.R
import com.example.basearchitecturemvvm.model.Fruit
import com.example.basearchitecturemvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_fruit.*

/**
 * Created by HungTran.V on 2020-07-01.
 */
class FruitDetailFragment : BaseFragment() {

    companion object {
        fun newInstance() = FruitDetailFragment()
    }

    private var fruit = arrayListOf<Fruit>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fruit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initRecyclerView()
    }

    private fun initData() {
        fruit.add(Fruit(R.drawable.orange, "Orange", "30000đ"))
        fruit.add(Fruit(R.drawable.onion, "Onion", "24000đ"))
        fruit.add(Fruit(R.drawable.tomato, "Tomato", "54000đ"))
        fruit.add(Fruit(R.drawable.apple, "Apple", "21000đ"))
        fruit.add(Fruit(R.drawable.mango_teen, "Mange Teen", "36000đ"))
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = FruitAdapter(fruit)
    }
}
