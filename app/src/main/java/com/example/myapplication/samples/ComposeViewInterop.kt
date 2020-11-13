package com.example.myapplication.samples

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.ui.platform.ComposeView
import com.example.myapplication.R

@SuppressLint("Registered")
class ComposeViewInterop : AppCompatActivity() {

    val composeView by lazy { findViewById<ComposeView>(R.id.composeView) }
    val androidView by lazy { findViewById<TextView>(R.id.composeView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compose_view_interop)

        composeView.setContent {
            Text(text = "ComposeText")
        }
        androidView.text = "Android Text"
    }


}
