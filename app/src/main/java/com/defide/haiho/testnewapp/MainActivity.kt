package com.defide.haiho.testnewapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick.setOnClickListener {
            tvHello.text = "Clicked $count"
            count++
        }

        edInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                tvHello.text = s
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        btnNext.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        supportFragmentManager.beginTransaction().replace(R.id.flContainer, FirstFragment()).commit()
    }

    fun yourAge(age: Int): String {
        return "Your age is $age"
    }
}
