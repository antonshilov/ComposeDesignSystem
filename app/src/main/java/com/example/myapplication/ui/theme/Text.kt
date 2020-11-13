package com.example.myapplication.ui.theme

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticAmbientOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import com.example.myapplication.samples.PreviewBackground

@Preview
@Composable
fun TextPreview() {
    PreviewBackground {
        Column {
            textStyles().forEach { style ->
                Text(
                    text = "Hello Mobius!",
                    style = style,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun TextH1Preview() {
    PreviewBackground {
        Text(
            text = "Hello Mobius!",
            style = TextStyles.H1,
            color = Color.White
        )
    }
}

@Composable
private fun textStyles(): List<TextStyle> = with(TextStyles) {
    listOf(H1, H2, Action, Title, P1, P2, P3)
}

@Immutable
data class Typography(
    val H1: TextStyle,
    val H2: TextStyle,
    val Action: TextStyle,
    val Title: TextStyle,
    val P1: TextStyle,
    val P2: TextStyle,
    val P3: TextStyle
)


val AmbientTypography = staticAmbientOf<Typography>()

@Composable
val TextStyles: Typography
    get() = AmbientTypography.current