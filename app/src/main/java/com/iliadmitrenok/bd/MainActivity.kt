package com.iliadmitrenok.bd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import android.content.Intent
import android.net.Uri


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fab_heart)

        fab.setOnClickListener { view ->
            val gmmIntentUri = Uri.parse("https://www.google.com/maps/place/35%C2%B040'51.4%22N+139%C2%B045'57.7%22E/@35.6809351,139.7654738,19z/data=!3m1!4b1!4m6!3m5!1s0x0:0x0!7e2!8m2!3d35.6809337!4d139.7660212")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}
