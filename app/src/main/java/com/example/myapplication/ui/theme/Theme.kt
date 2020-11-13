package com.example.myapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BadooTheme(content: @Composable () -> Unit) =
    Theme(
        typography = Typography(
            H1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                lineHeight = 28.sp
            ),
            H2 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                lineHeight = 25.sp
            ),
            Action = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp,
                lineHeight = 22.sp
            ),
            Title = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 24.sp
            ),
            P1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 22.sp
            ),
            P2 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                lineHeight = 20.sp
            ),
            P3 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                lineHeight = 16.sp
            )
        ),
        colors = ColorTokens(
            primary = Color(0xFF783bf9),
            matchPhotosBorder = Color.Transparent
        ),
        dimensions = DimensionTokens(
            tokenButtonCornerRadius = 12.dp,
            tokenMatchPhotosPhotoSize = 100.dp,
            tokenMatchPhotosRotationAngle = 10f,
            tokenMatchPhotosCornerRadius = 0.16f,
            tokenMatchPhotosIconSize = 0.5f,
            tokenMatchPhotosLeftTranslateX = 0.05f,
            tokenMatchPhotosLeftTranslateY = 0.17f,
            tokenMatchPhotosRightTranslateX = -0.06f,
            tokenMatchPhotosRightTranslateY = 0.27f,
            tokenMatchPhotosLeftZIndex = 2f,
            tokenMatchPhotosRightZIndex = 1f,
            tokenMatchPhotosBadgeElevation = 2.dp,
            tokenButtonPaddingHorizontal = 32.dp,
            tokenButtonPaddingVertical = 8.dp,
            tokenButtonHeight = 44.dp,
            tokenButtonIconSize = 22.dp,
            tokenButtonIconTextSpacing = 8.dp,
            tokenButtonDisabledOpacity = 0.6f,
            tokenButtonStrokeBorderWidth = 1.dp,
            tokenMatchPhotosBorderWidth = 0.dp,
        ),
        content = content
    )


@Composable
fun BumbleTheme(content: @Composable () -> Unit) =
    Theme(
        typography = Typography(
            H1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                lineHeight = 28.sp
            ),
            H2 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                lineHeight = 24.sp
            ),
            Action = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 24.sp
            ),
            Title = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 24.sp
            ),
            P1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 22.sp
            ),
            P2 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp
            ),
            P3 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 16.sp
            )
        ),
        colors = ColorTokens(
            primary = Color(0xFFffc629),
            matchPhotosBorder = Color.White
        ),
        dimensions = DimensionTokens(
            tokenButtonCornerRadius = 24.dp,
            tokenMatchPhotosPhotoSize = 100.dp,
            tokenMatchPhotosRotationAngle = 12f,
            tokenMatchPhotosCornerRadius = 0.2f,
            tokenMatchPhotosIconSize = 0.4f,
            tokenMatchPhotosLeftTranslateX = 0.05f,
            tokenMatchPhotosLeftTranslateY = 0.17f,
            tokenMatchPhotosRightTranslateX = -0.06f,
            tokenMatchPhotosRightTranslateY = 0.27f,
            tokenMatchPhotosLeftZIndex = 2f,
            tokenMatchPhotosRightZIndex = 2f,
            tokenMatchPhotosBadgeElevation = 1.dp,
            tokenButtonPaddingHorizontal = 32.dp,
            tokenButtonPaddingVertical = 8.dp,
            tokenButtonHeight = 48.dp,
            tokenButtonIconSize = 24.dp,
            tokenButtonIconTextSpacing = 8.dp,
            tokenButtonDisabledOpacity = 0.3f,
            tokenButtonStrokeBorderWidth = 1.dp,
            tokenMatchPhotosBorderWidth = 4.dp,
        ),
        content = content
    )


@Composable
fun Theme(
    typography: Typography,
    colors: ColorTokens,
    dimensions: DimensionTokens,
    content: @Composable () -> Unit
) {
    Providers(
        AmbientTypography provides typography,
        AmbientColors provides colors,
        AmbientDimensions provides dimensions,
    ) {
        content()
    }
}
