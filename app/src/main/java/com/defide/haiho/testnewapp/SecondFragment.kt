package com.defide.haiho.testnewapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvSecond.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.flContainer, ThirdFragment())?.commit()
        }

        btnSecond.setOnClickListener {
            tvSecond.text = "CLICKED"
        }
    }

    fun yourAge(age: Int): String {
        return "Your age is $age"
    }
}