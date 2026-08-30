package com.alibhaicodes.app

import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SecondActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val scrollView = ScrollView(this)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER_HORIZONTAL
        layout.setPadding(40, 30, 40, 40)
        layout.setBackgroundColor(Color.BLACK)

        // LOGO
        val logo = ImageView(this)
        logo.setImageResource(R.drawable.alibhai_logo)
        logo.adjustViewBounds = true
        logo.scaleType = ImageView.ScaleType.CENTER_INSIDE

        layout.addView(
            logo,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                300
            )
        )

        // TITLE
        val title = TextView(this)
        title.text = "ALI BHAI CODES"
        title.textSize = 28f
        title.setTextColor(Color.WHITE)
        title.gravity = Gravity.CENTER

        layout.addView(title)

        // SUBTITLE
        val subtitle = TextView(this)
        subtitle.text = "REDEEM • EARN • ENJOY"
        subtitle.textSize = 16f
        subtitle.setTextColor(Color.LTGRAY)
        subtitle.gravity = Gravity.CENTER
        subtitle.setPadding(0, 10, 0, 25)

        layout.addView(subtitle)

        // LOGIN TITLE
        val loginTitle = TextView(this)
        loginTitle.text = "LOGIN"
        loginTitle.textSize = 24f
        loginTitle.setTextColor(Color.WHITE)
        loginTitle.gravity = Gravity.CENTER

        layout.addView(loginTitle)

        // EMAIL
        val emailInput = EditText(this)
        emailInput.hint = "Enter Gmail"
        emailInput.textSize = 16f
        emailInput.setSingleLine(true)
        emailInput.inputType = InputType.TYPE_CLASS_TEXT or
                InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        emailInput.setTextColor(Color.WHITE)
        emailInput.setHintTextColor(Color.GRAY)

        layout.addView(
            emailInput,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // PASSWORD
        val passwordInput = EditText(this)
        passwordInput.hint = "Enter Password"
        passwordInput.textSize = 16f
        passwordInput.setSingleLine(true)
        passwordInput.inputType = InputType.TYPE_CLASS_TEXT or
                InputType.TYPE_TEXT_VARIATION_PASSWORD
        passwordInput.setTextColor(Color.WHITE)
        passwordInput.setHintTextColor(Color.GRAY)

        layout.addView(
            passwordInput,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // LOGIN BUTTON
        val loginButton = Button(this)
        loginButton.text = "LOGIN 🔐"
        loginButton.textSize = 16f

        layout.addView(
            loginButton,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // STATUS
        val status = TextView(this)
        status.text = "Not logged in"
        status.textSize = 16f
        status.setTextColor(Color.LTGRAY)
        status.gravity = Gravity.CENTER
        status.setPadding(0, 15, 0, 20)

        layout.addView(status)

        // REDEEM TITLE
        val redeemTitle = TextView(this)
        redeemTitle.text = "🎟️ REDEEM CODE"
        redeemTitle.textSize = 22f
        redeemTitle.setTextColor(Color.WHITE)
        redeemTitle.gravity = Gravity.CENTER

        layout.addView(redeemTitle)

        // REDEEM INPUT
        val redeemInput = EditText(this)
        redeemInput.hint = "Enter Redeem Code"
        redeemInput.textSize = 16f
        redeemInput.setSingleLine(true)
        redeemInput.setTextColor(Color.WHITE)
        redeemInput.setHintTextColor(Color.GRAY)

        layout.addView(
            redeemInput,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // REDEEM BUTTON
        val redeemButton = Button(this)
        redeemButton.text = "REDEEM 🎁"
        redeemButton.textSize = 16f
        redeemButton.isEnabled = false

        layout.addView(
            redeemButton,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // LOGOUT BUTTON
        val logoutButton = Button(this)
        logoutButton.text = "LOGOUT 🚪"
        logoutButton.textSize = 16f
        logoutButton.isEnabled = false

        layout.addView(
            logoutButton,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // LOGIN
        loginButton.setOnClickListener {

            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString()

            if (email.isEmpty()) {
                emailInput.error = "Enter Gmail"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordInput.error = "Enter Password"
                return@setOnClickListener
            }

            loginButton.isEnabled = false
            status.text = "Checking login..."

            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {

                    status.text = "✅ Logged in successfully"

                    loginButton.isEnabled = false
                    redeemButton.isEnabled = true
                    logoutButton.isEnabled = true

                    Toast.makeText(
                        this,
                        "Login successful!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .addOnFailureListener {

                    status.text = "❌ Wrong Gmail or Password"

                    loginButton.isEnabled = true
                    redeemButton.isEnabled = false
                    logoutButton.isEnabled = false

                    Toast.makeText(
                        this,
                        "Login failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }

        // REDEEM
        redeemButton.setOnClickListener {

            val code = redeemInput.text.toString().trim()

            if (code.isEmpty()) {
                redeemInput.error = "Enter Redeem Code"
                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Redeem code submitted!",
                Toast.LENGTH_SHORT
            ).show()
        }

        // LOGOUT
        logoutButton.setOnClickListener {

            auth.signOut()

            status.text = "Not logged in"

            loginButton.isEnabled = true
            redeemButton.isEnabled = false
            logoutButton.isEnabled = false

            emailInput.text.clear()
            passwordInput.text.clear()
            redeemInput.text.clear()

            Toast.makeText(
                this,
                "Logged out",
                Toast.LENGTH_SHORT
            ).show()
        }

        scrollView.addView(layout)
        setContentView(scrollView)
    }
}
