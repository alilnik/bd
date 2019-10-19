package com.iliadmitrenok.bd

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class PinkActivity : AppCompatActivity() {

    val fadeOut = AlphaAnimation(1f, 0f)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.pink_activity)
        val tilPinkAnswer = findViewById<TextInputLayout>(R.id.til_pink_answer)
        val etPinkAnswer = findViewById<TextInputEditText>(R.id.et_pink_answer)
        val ivOrange = findViewById<ImageView>(R.id.iv_orange)

        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.duration = 1000
        fadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation) {
                tilPinkAnswer.visibility = View.GONE
                ivOrange.visibility = View.GONE
                intent = Intent(this@PinkActivity, MainActivity::class.java)
                startActivity(intent)
            }

            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationStart(animation: Animation) {}
        })
        etPinkAnswer.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    if (s.toString().equals("blocparty")) {

                        tilPinkAnswer.startAnimation(fadeOut)
                        ivOrange.startAnimation(fadeOut)

                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, count: Int, start: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, before: Int) {}
        })
    }
}