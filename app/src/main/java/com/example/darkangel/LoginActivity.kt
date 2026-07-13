package com.example.darkangel

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val CORRECT_USERNAME = "yan"
    private val CORRECT_PASSWORD = "yan123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val backgroundView = findViewById<android.view.View>(R.id.background)
        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Animate background flash
        animateBackgroundFlash(backgroundView)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username == CORRECT_USERNAME && password == CORRECT_PASSWORD) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
                usernameInput.text.clear()
                passwordInput.text.clear()
            }
        }
    }

    private fun animateBackgroundFlash(view: android.view.View) {
        val animator = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 1.0f)
        animator.duration = 500
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.interpolator = LinearInterpolator()
        animator.start()
    }
}
