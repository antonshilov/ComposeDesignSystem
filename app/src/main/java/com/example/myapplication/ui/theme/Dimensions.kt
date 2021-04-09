package com.example.myapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class DimensionTokens(
    val tokenMatchPhotosPhotoSize: Dp = 0.dp,
    val tokenMatchPhotosRotationAngle: Float = 0f,
    val tokenMatchPhotosCornerRadius: Float = 0f,
    val tokenMatchPhotosIconSize: Float = 0f,
    val tokenMatchPhotosLeftTranslateX: Float = 0f,
    val tokenMatchPhotosLeftTranslateY: Float = 0f,
    val tokenMatchPhotosRightTranslateX: Float = 0f,
    val tokenMatchPhotosRightTranslateY: Float = 0f,
    val tokenMatchPhotosLeftZIndex: Float = 0f,
    val tokenMatchPhotosRightZIndex: Float = 0f,
    val tokenMatchPhotosBadgeElevation: Dp = 0.dp,
    val tokenButtonCornerRadius: Dp = 0.dp,
    val tokenButtonPaddingHorizontal: Dp = 0.dp,
    val tokenButtonPaddingVertical: Dp = 0.dp,
    val tokenButtonHeight: Dp = 0.dp,
    val tokenButtonIconSize: Dp = 0.dp,
    val tokenButtonIconTextSpacing: Dp = 0.dp,
    val tokenButtonDisabledOpacity: Float = 0f,
    val tokenButtonStrokeBorderWidth: Dp = 0.dp,
    val tokenMatchPhotosBorderWidth: Dp = 0.dp
)

val LocalDimensions = staticCompositionLocalOf { DimensionTokens() }

val Dimensions: DimensionTokens
    @Composable
    get() = LocalDimensions.current