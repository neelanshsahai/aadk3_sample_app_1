package com.example.aadk_3app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val tvWelcome: TextView = findViewById(R.id.tvWelcome)

        // Fetch the name from MainActivity and  display it here
//        val username = intent.getStringExtra(USERNAME_KEY)
//        val password = intent.getStringExtra(PASSWORD_KEY)

        val username = intent.extras?.getString(USERNAME_KEY)
        val password = intent.extras?.getString(PASSWORD_KEY)

        tvWelcome.text = "Welcome $username \n$password"
    }
}
