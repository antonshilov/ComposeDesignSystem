package com.example.myapplication.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.samples.PreviewBackground
import com.example.myapplication.ui.theme.Colors
import com.example.myapplication.ui.theme.Dimensions
import com.example.myapplication.ui.theme.TextStyles

@Composable
fun Button(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Colors.primary,
    contentColor: Color = Color.White,
    icon: Painter? = null,
    enabled: Boolean = true
) {
    ButtonSkeleton(
        onClick = onClick,
        modifier = modifier,
        backgroundColor = color,
        contentColor = contentColor,
        enabled = enabled,
        icon = icon,
        text = text,
    )
}

@Composable
fun StrokeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Colors.primary,
    icon: Painter? = null,
    text: String,
    enabled: Boolean = true
) {
    ButtonSkeleton(
        onClick = onClick,
        modifier = modifier,
        backgroundColor = Color.Transparent,
        contentColor = color,
        border = BorderStroke(Dimensions.tokenButtonStrokeBorderWidth, color),
        enabled = enabled,
        icon = icon,
        text = text
    )

}

@Composable
fun TransparentButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Colors.primary,
    icon: Painter? = null,
    text: String,
    enabled: Boolean = true
) {
    ButtonSkeleton(
        onClick = onClick,
        modifier = modifier,
        backgroundColor = Color.Transparent,
        contentColor = color,
        enabled = enabled,
        icon = icon,
        text = text
    )

}

@Preview
@Composable
fun PreviewFilledButton() {
    PreviewBackground {
        Column {
            Button(
                onClick = {},
                text = "Mobius rules",
                icon = painterResource(id = R.drawable.ic_autorenew),
                modifier = Modifier.padding(16.dp),
            )
            Button(
                onClick = {},
                text = "Mobius rules",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewOutlined() {
    PreviewBackground(color = Color.White) {
        Column {
            StrokeButton(
                onClick = {},
                text = "Mobius rules",
                icon = painterResource(id = R.drawable.ic_autorenew),
                modifier = Modifier.padding(16.dp)
            )
            StrokeButton(
                onClick = {},
                text = "Mobius rules",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTransparent() {
    PreviewBackground(color = Color.White) {
        Column {
            TransparentButton(
                onClick = {},
                text = "Mobius rules",
                icon = painterResource(id = R.drawable.ic_autorenew),
                modifier = Modifier.padding(16.dp)
            )
            TransparentButton(
                onClick = {},
                text = "Mobius rules",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
private fun ButtonSkeleton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(Dimensions.tokenButtonCornerRadius),
    border: BorderStroke? = null,
    backgroundColor: Color,
    contentColor: Color = Color.White,
    contentPadding: PaddingValues = PaddingValues(
        start = Dimensions.tokenButtonPaddingHorizontal,
        end = Dimensions.tokenButtonPaddingHorizontal,
        top = Dimensions.tokenButtonPaddingVertical,
        bottom = Dimensions.tokenButtonPaddingVertical
    ),
    height: Dp = Dimensions.tokenButtonHeight,
    icon: Painter?,
) {
    val interactionState = remember { MutableInteractionSource() }
    Surface(
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
        border = border,
        modifier =
        modifier
            .clickable(
                onClick = onClick,
                enabled = enabled,
                interactionSource = interactionState,
                indication = null
            )
            .alpha(
                if (enabled) 1f else Dimensions.tokenButtonDisabledOpacity
            )
    ) {
        Row(
            Modifier
                .defaultMinSize(minHeight = height)
                .indication(interactionState, rememberRipple())
                .padding(contentPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (icon != null) {
                Icon(
                    modifier = Modifier.size(Dimensions.tokenButtonIconSize),
                    painter = icon,
                    tint = contentColor,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(Dimensions.tokenButtonIconTextSpacing))
            }
            Text(
                text = text,
                style = TextStyles.Action,
                color = contentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

