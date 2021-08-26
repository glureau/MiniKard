package com.glureau.minikard.ui.shared

import android.R
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import coil.compose.rememberImagePainter

@Composable
fun RoundedPicture(
    pictureUrl: String?,
    @DrawableRes placeholder: Int = R.drawable.ic_menu_gallery,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = rememberImagePainter(data = pictureUrl,
            builder = { placeholder(placeholder).crossfade(true) }),
        contentDescription = null,
        modifier = modifier.clip(CircleShape)
    )
}