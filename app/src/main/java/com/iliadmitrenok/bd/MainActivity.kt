package com.iliadmitrenok.bd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    val fadeIn = AlphaAnimation(0f, 1f)
    val fadeOut = AlphaAnimation(1f, 0f)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tilBlueAnswer = findViewById<TextInputLayout>(R.id.til_blue_answer)
        val etBlueAnswer = findViewById<TextInputEditText>(R.id.tf_blue_answer)
        val tvCall = findViewById<TextView>(R.id.tv_call)
        val tvDumbledore = findViewById<TextView>(R.id.tv_dumbledore)
        val fabOpenMap = findViewById<FloatingActionButton>(R.id.fab_open_map)

        fabOpenMap.setOnClickListener {
            val mapUri = Uri.parse("https://www.google.com/maps?q=loc:35.6816889,139.7683806")
            val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        etBlueAnswer.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    if (s.toString().equals("olives")) {

                        tvCall.startAnimation(fadeOut)
                        tvDumbledore.startAnimation(fadeOut)
                        tilBlueAnswer.startAnimation(fadeOut)

                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, count: Int, start: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, before: Int) {}
        })

        fadeIn.interpolator = AccelerateInterpolator()
        fadeIn.duration = 1000
        fadeIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation) {
                fabOpenMap.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationStart(animation: Animation) {}
        })

        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.duration = 1000
        fadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation) {
                tilBlueAnswer.visibility = View.GONE
                tvCall.visibility = View.GONE
                tvDumbledore.visibility = View.GONE
                fabOpenMap.visibility = View.INVISIBLE
                fabOpenMap.startAnimation(fadeIn)
            }

            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationStart(animation: Animation) {}
        })
    }
}
