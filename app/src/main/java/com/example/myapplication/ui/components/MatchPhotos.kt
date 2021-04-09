package com.example.myapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.example.myapplication.R
import com.example.myapplication.samples.PreviewBackground
import com.example.myapplication.ui.theme.Colors
import com.example.myapplication.ui.theme.Dimensions

@Composable
fun MatchPhotos(
    leftPhoto: Painter,
    rightPhoto: Painter,
    badge: Painter,
    modifier: Modifier = Modifier
) {
    val photoSize = Dimensions.tokenMatchPhotosPhotoSize
    val rotationDegrees = Dimensions.tokenMatchPhotosRotationAngle
    val photoCornerRadius = photoSize * Dimensions.tokenMatchPhotosCornerRadius
    val photoShape = RoundedCornerShape(photoCornerRadius)
    val iconSize = photoSize * Dimensions.tokenMatchPhotosIconSize
    val photoSizePx = with(LocalDensity.current) { photoSize.toPx() }
    val leftTranslateX = photoSizePx * Dimensions.tokenMatchPhotosLeftTranslateX
    val leftTranslateY = photoSizePx * Dimensions.tokenMatchPhotosLeftTranslateY
    val rightTranslateX = photoSizePx * Dimensions.tokenMatchPhotosRightTranslateX
    val rightTranslateY = photoSizePx * Dimensions.tokenMatchPhotosRightTranslateY

    Column(modifier = modifier) {
        Row {
            Image(
                painter = leftPhoto,
                modifier = Modifier
                    .graphicsLayer(
                        rotationZ = -rotationDegrees,
                        translationX = leftTranslateX,
                        translationY = leftTranslateY
                    )
                    .zIndex(Dimensions.tokenMatchPhotosLeftZIndex)
                    .size(photoSize)
                    .border(
                        width = Dimensions.tokenMatchPhotosBorderWidth,
                        Colors.matchPhotosBorder,
                        photoShape
                    )
                    .padding(Dimensions.tokenMatchPhotosBorderWidth / 2)
                    .clip(photoShape),
                contentDescription = null

            )
            Image(
                painter = rightPhoto,
                modifier = Modifier
                    .graphicsLayer(
                        clip = false,
                        rotationZ = rotationDegrees,
                        translationX = rightTranslateX,
                        translationY = rightTranslateY
                    )
                    .zIndex(Dimensions.tokenMatchPhotosRightZIndex)
                    .size(photoSize)
                    .border(
                        width = Dimensions.tokenMatchPhotosBorderWidth,
                        Colors.matchPhotosBorder,
                        photoShape
                    )
                    .padding(Dimensions.tokenMatchPhotosBorderWidth / 2)
                    .clip(photoShape),
                contentDescription = null
            )

        }
        Image(
            painter = badge,
            modifier = Modifier
                .size(iconSize)
                .align(Alignment.CenterHorizontally)
                .shadow(
                    elevation = Dimensions.tokenMatchPhotosBadgeElevation,
                    shape = CircleShape
                ),
            contentDescription = null
        )

    }
}

@Preview
@Composable
fun PreviewMatchPhotos() {
    PreviewBackground {
        MatchPhotos(
            leftPhoto = painterResource(R.drawable.image1),
            rightPhoto = painterResource(R.drawable.image2),
            badge = painterResource(R.drawable.ic_match_badoo)
        )
    }
}
