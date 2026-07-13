package com.example.darkangel

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BugCrashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bug_crash)

        val backgroundView = findViewById<android.view.View>(R.id.background)
        val bugSpinner = findViewById<Spinner>(R.id.bugSpinner)
        val attackButton = findViewById<Button>(R.id.attackButton)
        val backButton = findViewById<Button>(R.id.backButton)

        // Animate background flash
        animateBackgroundFlash(backgroundView)

        attackButton.setOnClickListener {
            val selectedBug = bugSpinner.selectedItem.toString()
            Toast.makeText(this, "Attacking: $selectedBug", Toast.LENGTH_SHORT).show()
            // Add your attack logic here
        }

        backButton.setOnClickListener {
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
