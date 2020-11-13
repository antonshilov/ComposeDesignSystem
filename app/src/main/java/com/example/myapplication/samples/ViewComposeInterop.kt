package com.example.myapplication.samples

import android.widget.TextView
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.viewinterop.AndroidView
import androidx.ui.tooling.preview.Preview
import com.example.myapplication.R

@Composable
fun ViewComposeInterop() {

    val count = remember { mutableStateOf(0) }

    val context = ContextAmbient.current

    val textView = remember {
        TextView(context).apply {
            setOnClickListener {
                count.value = count.value + 1
            }
            setTextColor(context.resources.getColor(R.color.white))
            contentDescription = "CounterAndroidView"
        }
    }


    Column {
        Text(text = "Compose Text Count = ${count.value}")
        AndroidView(viewBlock = { textView }) { view ->
            view.text = "Hello From AndroidViews World! Count = ${count.value}"
        }
    }

}


@Preview
@Composable
fun PreviewCounter() {
    PreviewBackground {
        ViewComposeInterop()
    }
}
