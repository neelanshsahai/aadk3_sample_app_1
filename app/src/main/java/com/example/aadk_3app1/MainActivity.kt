package com.example.aadk_3app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

// One Screen per activity
// With Fragments we can have multiple UI Screens with one Activity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btnLogin)
        val etUserName: TextInputEditText = findViewById(R.id.tietUsername)
        val etPassword: TextInputEditText = findViewById(R.id.tietPassword)

        val usernameLayout: TextInputLayout = findViewById(R.id.etUsername)
        val passwordLayout: TextInputLayout = findViewById(R.id.etPassword)

        // TODO: Understand how can you clear the error
        btn.setOnClickListener {
            val username = etUserName.text.toString()
            val password = etPassword.text.toString()

            if (username.isBlank()) {
                // Show an error "Please enter a valid username"
                usernameLayout.error = "Please enter a valid username"
            }

            if (password.isEmpty()) {
                // Show error
                passwordLayout.error = "Please enter a password first"
            }

            // If everything is fine, then submit
            if (checkFormDetails(username, password)) {
                Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkFormDetails(username: String, password: String): Boolean {
        return !(username.isBlank() || password.isEmpty())
    }
}
