package com.alibhaicodes.app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this)
        textView.text = "Welcome to Ali Bhai Codes"
        textView.textSize = 24f
        textView.setPadding(40, 40, 40, 40)

        setContentView(textView)
    }
}
