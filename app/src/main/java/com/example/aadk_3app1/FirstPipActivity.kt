package com.example.aadk_3app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aadk_3app1.databinding.ActivityFirstPipBinding

class FirstPipActivity : AppCompatActivity() {

    private val binding1 by lazy { ActivityFirstPipBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding1.root)

        val uriString = "android.resource://$packageName/${R.raw.sample}"
        val intent = Intent(this, SecondPipActivity::class.java)

        binding1.btn1.setOnClickListener {
            intent.putExtra("URI", uriString)
            intent.putExtra("COLOR", "255 0 0")
            startActivity(intent)
        }

        binding1.btn2.setOnClickListener {
            intent.putExtra("URI", uriString)
            intent.putExtra("COLOR", "0 255 0")
            startActivity(intent)
        }

        binding1.btn3.setOnClickListener {
            intent.putExtra("URI", uriString)
            intent.putExtra("COLOR", "0 0 255")
            startActivity(intent)
        }
    }
}
