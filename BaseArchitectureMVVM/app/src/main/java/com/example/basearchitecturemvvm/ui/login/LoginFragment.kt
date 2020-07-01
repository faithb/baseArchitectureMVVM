package com.example.basearchitecturemvvm.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.basearchitecturemvvm.R
import com.example.basearchitecturemvvm.extension.afterTextChanged
import com.example.basearchitecturemvvm.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created by HungTran.V on 2020-07-01.
 */
class LoginFragment : Fragment() {

    companion object {
        fun newInstance() =
            LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initTextChange()
    }

    private fun initListener() {
        btnLogin.setOnClickListener {
            if (edtUsername.text.toString() == "1" && edtPassword.text.toString() == "1") {
                tvError.visibility = View.INVISIBLE
                (activity as? MainActivity)?.openHomeFragment()
            } else {
                tvError.visibility = View.VISIBLE
            }
        }
    }

    private fun initTextChange() {
        edtUsername.afterTextChanged {
            tvError.visibility = View.INVISIBLE
        }
        edtPassword.afterTextChanged {
            tvError.visibility = View.INVISIBLE
        }
    }
}