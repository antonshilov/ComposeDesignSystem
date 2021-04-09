package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.samples.PreviewBackground
import com.example.myapplication.ui.theme.Spacing

@Composable
fun CtaBox(
    media: @Composable () -> Unit,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
    buttons: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(Spacing.xlg)
    ) {
        media()
        Spacer(modifier = Modifier.size(Spacing.xlg))
        header()
        Spacer(modifier = Modifier.size(Spacing.md))
        content()
        Spacer(modifier = Modifier.size(Spacing.xlg))
        Column {
            buttons()
        }
    }
}


@Preview
@Composable
fun PreviewCtaBox() {
    PreviewBackground {
        CtaBox(
            media = {
                Surface(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .size(80.dp)
                ) {
                    Text(
                        text = "Media",
                        color = Color.Black,
                        modifier = Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center
                    )
                }
            },
            header = {
                Surface(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .size(200.dp, 24.dp)
                ) {
                    Text(
                        text = "Header",
                        color = Color.Black,
                        modifier = Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center
                    )
                }
            },
            content = {
                Surface(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .size(200.dp, 100.dp)
                ) {
                    Text(
                        text = "Content",
                        color = Color.Black,
                        modifier = Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center
                    )
                }
            },
            buttons = {
                Surface(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .size(200.dp, 24.dp)
                ) {
                    Text(
                        text = "Buttons",
                        color = Color.Black,
                        modifier = Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    }
}
