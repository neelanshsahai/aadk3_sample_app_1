package com.example.aadk_3app1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aadk_3app1.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

// One Screen per activity
// With Fragments we can have multiple UI Screens with one Activity

// Second Activity is Welcome Activity
// I want to go to that screen once the user is logged in

// TODO 1: How to pass a data class object from one activity to the other, using Intents
// TODO 2: How to pass a normal class object from one activity to the other, using Intents
// TODO: Parcelable and Serializable
class MainActivity : AppCompatActivity() {

    // Within the scope of this activity, you can get its reference by using `this` keyword

    private lateinit var myAuth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myAuth = FirebaseAuth.getInstance()

        // TODO: Understand how can you clear the error
        binding.btnLogin.setOnClickListener {
            val username = binding.tietUsername.text.toString()
            val password = binding.tietPassword.text.toString()

            if (username.isBlank()) {
                // Show an error "Please enter a valid username"
                binding.etUsername.error = "Please enter a valid username"
            }

            if (password.isEmpty()) {
                // Show error
                binding.etPassword.error = "Please enter a password first"
            }

            // check if user exists
            // if exists goto next screen
            // if not create a user with the given mail id and password


            // If everything is fine, then submit
            if (checkFormDetails(username, password)) {
//                Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()

                myAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener { signInTask ->
                    if (signInTask.isSuccessful) {
                        Log.d("wiuebf", "Sign In Successful")
                    } else {
                        Log.d("keyfefyv", "${signInTask.exception}")
                        // Add a check
                        // if (it.exception is of the type FirebaseAuthInvalidUserException) {
                        // Create a new user
                        myAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener { signUpTask ->
                            if (signUpTask.isSuccessful) {
                                Log.d("wjhbvi", "SignUp Successful")
                            } else {
                                Log.d("iuebfon", "${signUpTask.exception}")
                            }
                        }
                    }
                }

                // TODO: Goto the next activity
                /*
                * Intents -> One of the use of intents is to navigate to a new Activity
                * passing data
                * Start a Service
                * Open some other app
                * Broadcasting a message
                * */

                /*
                * Intents are of 2 types
                * 1- Explicit Intents -> Used for internal navigation - from one activity to other (in the same app)
                * 2- Implicit Intents -> Used for external navigation - from one activity to other app
                * */

                /* EXPLICIT INTENT
                * Intent(sender's context, receiver's reference to the java class)
                * */

                // BUNDLE -> Key Value pair object in Android
//                val intent = Intent(this@MainActivity, WelcomeActivity::class.java)
//                intent.putExtra(USERNAME_KEY, username)
//                intent.putExtra(PASSWORD_KEY, password)
//                val bundle = Bundle()
//                bundle.putString(USERNAME_KEY, username)
//                bundle.putString(PASSWORD_KEY, password)
//                intent.putExtras(bundle)
//
//                startActivity(intent)
            }
        }

        /*
        * URI -> Uniform Resource Identifier
        * URL -> Uniform Resource Locator
        * */

        binding.tvGotoFAQs.setOnClickListener {
            // IMPLICIT INTENT -> Action
            // Redirect this to a webpage - (https://www.geeksforgeeks.org) -> convert the url to a URI
            val url = "https://www.geeksforgeeks.org"
            val uri = Uri.parse(url)
            // How we log things / errors
            Log.d("AADK3CustomTag1", url)
            Log.d("AADK3CustomTag2", uri.toString())
            val implicitIntent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(implicitIntent)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        // Display a toast that the user has exitted this activity
        super.onDestroy()
    }

    private fun checkFormDetails(username: String, password: String): Boolean {
        return !(username.isBlank() || password.isEmpty())
    }
}

// Lifecycle of an Activity
/*
1. Created - Activity created, basic skeleton. Quickly jumps to start
2. Started - Visible to the user. Quickly jumps to resume
3. Resumed - Comes to the foreground and is now ready for user interaction
__________

4. Paused - even a hint, that the user is leaving the activity
5. Stopped - activity goes into the background
6. Destroyed - activity is removed from the tray
*/
