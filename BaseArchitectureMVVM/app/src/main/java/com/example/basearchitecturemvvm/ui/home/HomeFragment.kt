package com.example.basearchitecturemvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basearchitecturemvvm.R
import com.example.basearchitecturemvvm.ui.MainActivity
import com.example.basearchitecturemvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by HungTran.V on 2020-07-01.
 */
class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        tvBang1.setOnClickListener {
            (activity as? MainActivity)?.openFruitDetailFragment()
        }
        tvBang2.setOnClickListener {
            (activity as? MainActivity)?.openFruitClassFicationFragment()
        }
        tvBang3.setOnClickListener {
            //todo: move bang 3 detail
        }
        tvBang4.setOnClickListener {
            //todo: move bang 4 detail
        }
    }
}