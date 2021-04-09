package com.example.myapplication.samples

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.components.Button
import com.example.myapplication.ui.components.CtaBox
import com.example.myapplication.ui.components.MatchPhotos
import com.example.myapplication.ui.theme.BadooTheme
import com.example.myapplication.ui.theme.BumbleTheme
import com.example.myapplication.ui.theme.Colors
import com.example.myapplication.ui.theme.TextStyles

@Preview
@Composable
fun PreviewCtaBoxBadoo() {
    BadooTheme {
        MatchScreen(
            config = matchConfig().copy(badge = painterResource(R.drawable.ic_match_badoo))
        )
    }
}

@Preview
@Composable
fun PreviewCtaBoxBumble() {
    BumbleTheme {
        MatchScreen(config = matchConfig())
    }
}


data class MatchConfig(
    val firstUserPhoto: Painter,
    val secondUserPhoto: Painter,
    val badge: Painter,
    val header: String,
    val content: String,
    val ctaText: String
)

@Composable
fun matchConfig() = MatchConfig(
    firstUserPhoto = painterResource(R.drawable.image1),
    secondUserPhoto = painterResource(R.drawable.image2),
    badge = painterResource(R.drawable.ic_match_bumble),
    header = "You have a new match!",
    content = "Hugo matched with you while you were away. Now’s the perfect time to send them a message",
    ctaText = "Send Message"
)

@Composable
fun MatchScreen(config: MatchConfig) {
    Surface(color = Colors.primary) {
        CtaBox(
            media = {
                MatchPhotos(
                    leftPhoto = config.firstUserPhoto,
                    rightPhoto = config.secondUserPhoto,
                    badge = config.badge,
                    modifier = Modifier.testTag(TestTagMatchScreen.matchPhotos)
                )
            },
            header = {
                Text(
                    text = config.header,
                    style = TextStyles.H1,
                    color = Color.White,
                    modifier = Modifier.testTag(TestTagMatchScreen.header)
                )
            },
            content = {
                Text(
                    text = config.content,
                    style = TextStyles.P1,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.testTag(TestTagMatchScreen.content)
                        .padding(horizontal = 48.dp)
                )
            },
            buttons = {
                Button(
                    onClick = {},
                    text = config.ctaText,
                    color = Color.White,
                    contentColor = Color.Black,
                    modifier = Modifier.testTag(TestTagMatchScreen.cta)
                )
            }
        )
    }
}

object TestTagMatchScreen {
    const val matchPhotos = "MatchScreenPhotos"
    const val header = "MatchScreenHeader"
    const val content = "MatchScreenContent"
    const val cta = "MatchScreenCta"
}
