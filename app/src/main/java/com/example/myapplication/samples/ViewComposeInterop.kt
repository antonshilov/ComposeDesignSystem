package com.example.myapplication.samples

import android.widget.TextView
import androidx.compose.material.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R

@Composable
fun ViewComposeInterop() {
    val count = remember { mutableStateOf(0) }

    Column {
        Text(text = "Compose Text Count = ${count.value}")
        AndroidView(
            factory = { context ->
                TextView(context).apply {
                    setOnClickListener {
                        count.value = count.value + 1
                    }
                    setTextColor(context.resources.getColor(R.color.white))
                    contentDescription = "CounterAndroidView"
                }
            },
            update = { view: TextView ->
                view.text = "Hello From AndroidViews World! Count = ${count.value}"
            }
        )
    }

}


@Preview
@Composable
fun PreviewCounter() {
    PreviewBackground {
        ViewComposeInterop()
    }
}
