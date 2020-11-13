package com.example.myapplication.samples

import androidx.compose.foundation.Image
import androidx.compose.foundation.ProvideTextStyle
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonConstants
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.ambientOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
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
            colors = ButtonConstants.defaultButtonColors(backgroundColor = Color.Red)
        ) {
            Button(
                onClick = {},
                colors = ButtonConstants.defaultButtonColors(backgroundColor = Color.Green)
            ) {
                Button(
                    onClick = {},
                    colors = ButtonConstants.defaultButtonColors(backgroundColor = Color.Blue)
                ) {
                    Text(text = "We need to go deeper", color = Color.White)
                }

            }
        }
    }
}

val AmbientHeartColor = ambientOf<Color>()

@Composable
fun HeartsScreen() {
    Providers(
        AmbientHeartColor provides Color.Red
    ) {
        ContextAmbient
        AmbientHeartColor.current // I can access color here
    }
}

@Composable
fun PreviewBackground(
    color: Color = Color(0xFF53585F),
    content: @Composable () -> Unit) {
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
            Image(imageResource(id = R.drawable.image1), modifier = Modifier.size(128.dp))
            Spacer(modifier = Modifier.size(16.dp))
            Image(vectorResource(id = R.drawable.ic_match_badoo), modifier = Modifier.size(128.dp))
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
