package com.alibhaicodes.app

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(40, 40, 40, 40)
        layout.setBackgroundColor(Color.WHITE)

        val title = TextView(this)
        title.text = "Welcome to Page 2 🔥"
        title.textSize = 28f
        title.setTextColor(Color.BLACK)
        title.gravity = Gravity.CENTER

        val message = TextView(this)
        message.text = "Ali Bhai Codes 🚀"
        message.textSize = 20f
        message.setTextColor(Color.DKGRAY)
        message.gravity = Gravity.CENTER
        message.setPadding(0, 30, 0, 0)

        layout.addView(title)
        layout.addView(message)

        setContentView(layout)
    }
}
