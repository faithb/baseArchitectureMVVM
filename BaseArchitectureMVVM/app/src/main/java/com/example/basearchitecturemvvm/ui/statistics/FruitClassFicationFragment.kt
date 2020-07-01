package com.example.basearchitecturemvvm.ui.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basearchitecturemvvm.R
import com.example.basearchitecturemvvm.model.Fruit
import com.example.basearchitecturemvvm.model.FruitClassFication
import com.example.basearchitecturemvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_fruit.*

/**
 * Created by HungTran.V on 2020-07-01.
 */
class FruitClassFicationFragment : BaseFragment() {

    companion object {
        fun newInstance() = FruitClassFicationFragment()
    }

    private var fruit = arrayListOf<FruitClassFication>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fruit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle.text = "Fruit ClassFication"
        initData()
        initRecyclerView()
    }

    private fun initData() {
        fruit.add(FruitClassFication("Orange", "2", "60000d"))
        fruit.add(FruitClassFication("Onion", "1", "48000d"))
        fruit.add(FruitClassFication("Tomato", "3", "162000d"))
        fruit.add(FruitClassFication("Apple", "4", "82000d"))
        fruit.add(FruitClassFication("Mange Teen", "1", "36000d"))
        fruit.add(FruitClassFication("Total", "11", "388000d"))
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = FruitClassFicationAdapter(fruit)
    }
}
