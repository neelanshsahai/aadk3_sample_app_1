package com.example.aadk_3app1

import android.app.ActivityOptions
import android.app.PictureInPictureParams
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Rect
import android.net.Uri
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.util.Rational
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.aadk_3app1.databinding.ActivitySecondPipBinding

class SecondPipActivity : AppCompatActivity() {

    private val binding2 by lazy { ActivitySecondPipBinding.inflate(layoutInflater) }
    private var bounds = Rect()
    private val uriString by lazy { "android.resource://$packageName/${R.raw.sample}" }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: Configuration) {
        if (VERSION.SDK_INT >= VERSION_CODES.O) {
            super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
            if (isInPictureInPictureMode) {
                binding2.toolbar.visibility = View.GONE
                binding2.textview.visibility = View.GONE
            } else {
                binding2.toolbar.visibility = View.VISIBLE
                binding2.textview.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding2.root)

        val color = "0 0 0"
//        intent?.extras?.let {
//            uriString = it.getString("URI", "")
//            color = it.getString("COLOR", "0 0 0")
//        }

        binding2.video.apply {
            setVideoURI(Uri.parse(uriString))
            addOnLayoutChangeListener { v, _, _, _, _, _, _, _, _ ->
                v.getGlobalVisibleRect(bounds)
                if (VERSION.SDK_INT >= VERSION_CODES.TIRAMISU) {
                    val builder = PictureInPictureParams.Builder()

                    builder.setSourceRectHint(bounds)

                    builder.setAutoEnterEnabled(true)

                    val aspectRatio = if (bounds.width() / bounds.height() > 2.39) {
                        Rational(2151, 900)
                    } else if (bounds.width() / bounds.height() < 0.418410) {
                        Rational(900, 2151)
                    } else {
                        Rational(bounds.width(), bounds.height())
                    }
                    builder.setAspectRatio(aspectRatio)

                    setPictureInPictureParams(builder.build())
                }
            }
            start()
        }

        val r = color.split(" ")[0].toInt()
        val g = color.split(" ")[1].toInt()
        val b = color.split(" ")[2].toInt()
        binding2.textview.setBackgroundColor(Color.argb(1, r, g, b))

    }

    override fun onBackPressed() {
        if (VERSION.SDK_INT >= VERSION_CODES.TIRAMISU) {
            val intent = Intent(this, SecondPipActivity::class.java)
            intent.putExtra("URI", uriString)
            intent.putExtra("COLOR", "127 127 127")
            val builder = PictureInPictureParams.Builder()
            builder.setSourceRectHint(bounds)
            builder.setAutoEnterEnabled(true)
            builder.setAspectRatio(Rational(1, 1))
            val opts = ActivityOptions.makeLaunchIntoPip(builder.build())
            startActivity(intent, opts.toBundle())
        } else {
            super.onBackPressed()
        }
    }
}
