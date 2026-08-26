package com.alibhaicodes.app

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(40, 40, 40, 40)
        layout.setBackgroundColor(Color.WHITE)

        val title = TextView(this)
        title.text = "Ali Bhai Codes"
        title.textSize = 32f
        title.setTextColor(Color.BLACK)
        title.gravity = Gravity.CENTER

        val subtitle = TextView(this)
        subtitle.text = "Welcome! Let's build something awesome 🚀"
        subtitle.textSize = 18f
        subtitle.setTextColor(Color.DKGRAY)
        subtitle.gravity = Gravity.CENTER
        subtitle.setPadding(0, 20, 0, 40)

        val startButton = Button(this)
        startButton.text = "START"
        startButton.textSize = 18f

        startButton.setOnClickListener {
            title.text = "Let's Go! 🔥"
            subtitle.text = "Welcome to Ali Bhai Codes"
            startButton.text = "STARTED ✓"
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(startButton)

        setContentView(layout)
    }
}
