package com.example.darkangel

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val backgroundView = findViewById<android.view.View>(R.id.background)
        val bugCrashButton = findViewById<Button>(R.id.bugCrashButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        // Animate background flash
        animateBackgroundFlash(backgroundView)

        bugCrashButton.setOnClickListener {
            startActivity(Intent(this, BugCrashActivity::class.java))
        }

        logoutButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
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
