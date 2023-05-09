package com.kipreev.aston_intensiv_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var buttonToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToast = findViewById(R.id.buttonToast)

        buttonToast.setOnClickListener {
            Toast.makeText(this, "This is Toast", Toast.LENGTH_SHORT).show()
        }
    }
}
