package com.example.myapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticAmbientOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

data class DimensionTokens(
    val tokenMatchPhotosPhotoSize: Dp,
    val tokenMatchPhotosRotationAngle: Float,
    val tokenMatchPhotosCornerRadius: Float,
    val tokenMatchPhotosIconSize: Float,
    val tokenMatchPhotosLeftTranslateX: Float,
    val tokenMatchPhotosLeftTranslateY: Float,
    val tokenMatchPhotosRightTranslateX: Float,
    val tokenMatchPhotosRightTranslateY: Float,
    val tokenMatchPhotosLeftZIndex: Float,
    val tokenMatchPhotosRightZIndex: Float,
    val tokenMatchPhotosBadgeElevation: Dp,
    val tokenButtonCornerRadius: Dp,
    val tokenButtonPaddingHorizontal: Dp,
    val tokenButtonPaddingVertical: Dp,
    val tokenButtonHeight: Dp,
    val tokenButtonIconSize: Dp,
    val tokenButtonIconTextSpacing: Dp,
    val tokenButtonDisabledOpacity: Float,
    val tokenButtonStrokeBorderWidth: Dp,
    val tokenMatchPhotosBorderWidth: Dp
)

val AmbientDimensions = staticCompositionLocalOf<DimensionTokens>()

@Composable
val Dimensions: DimensionTokens
    get() = AmbientDimensions.current
