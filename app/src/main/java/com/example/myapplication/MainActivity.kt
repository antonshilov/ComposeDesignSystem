package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.ui.platform.setContent
import com.example.myapplication.samples.PreviewCtaBoxBadoo
import com.example.myapplication.samples.PreviewCtaBoxBumble

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                PreviewCtaBoxBadoo()
                PreviewCtaBoxBumble()
            }
        }
    }


}

