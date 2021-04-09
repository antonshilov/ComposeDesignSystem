package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.ComposeView
import com.example.myapplication.samples.PreviewCtaBoxBadoo
import com.example.myapplication.samples.PreviewCtaBoxBumble

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val composeView = ComposeView(this)
        composeView.setContent {
            Column {
                PreviewCtaBoxBadoo()
                PreviewCtaBoxBumble()
            }
        }
        setContentView(composeView)
    }
}

