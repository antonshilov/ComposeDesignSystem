package com.example.myapplication.samples

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.BadooTheme
import com.example.myapplication.ui.theme.Spacing

@Preview
@Composable
fun HelloMobius(modifier: Modifier = Modifier) {
    PreviewBackground {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Hi there!")
            Text(text = "Welcome to the talk")
            Button(onClick = {}) {
                Text(text = "Let's start!")
            }
        }
    }
}


@Preview
@Composable
fun SlotApi() {
    PreviewBackground {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                ) {
                    Text(text = "We need to go deeper", color = Color.White)
                }

            }
        }
    }
}

val LocalHeartColor = compositionLocalOf { Color.Red }

@Composable
fun HeartsScreen() {
    CompositionLocalProvider(
        LocalHeartColor provides Color.Red
    ) {
        LocalHeartColor.current // I can access color here
    }
}

@Composable
fun PreviewBackground(
    color: Color = Color(0xFF53585F),
    content: @Composable () -> Unit
) {
    BadooTheme {
        Box(
            modifier = Modifier
                .background(color)
                .padding(Spacing.xlg)
        ) {
            ProvideTextStyle(value = TextStyle(color = Color.White)) {
                content()
            }
        }
    }

}

@Preview
@Composable
fun ColorSamples() {
    colorResource(id = R.color.black)
    Color(0xFF783bf9)

    val sizeDp = 16.dp
    val sizeSp = 16.sp
    dimensionResource(id = R.dimen.material_emphasis_medium)

    PreviewBackground {
        Column {
            Image(
                painter = painterResource(id = R.drawable.image1),
                modifier = Modifier.size(128.dp),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_match_badoo),
                modifier = Modifier.size(128.dp),
                contentDescription = null
            )
            Icons.Filled.Sort

        }
    }


    MaterialTheme.typography.h1
}

@Preview
@Composable
fun MaterialButton() {
    PreviewBackground {
        Button(
            onClick = {},
            content = { Text(text = "Hello Mobius") }
        )
    }
}
