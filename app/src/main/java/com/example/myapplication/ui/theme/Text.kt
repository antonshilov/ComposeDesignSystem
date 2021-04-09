package com.example.myapplication.ui.theme

import androidx.compose.material.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
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
    val H1: TextStyle = TextStyle.Default,
    val H2: TextStyle = TextStyle.Default,
    val Action: TextStyle = TextStyle.Default,
    val Title: TextStyle = TextStyle.Default,
    val P1: TextStyle = TextStyle.Default,
    val P2: TextStyle = TextStyle.Default,
    val P3: TextStyle = TextStyle.Default
)


val LocalTypography = staticCompositionLocalOf { Typography() }

val TextStyles: Typography
    @Composable
    get() = LocalTypography.current
