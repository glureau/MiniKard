package com.glureau.minikard.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.glureau.minikard.ui.theme.KardMoneyBackground

val shapeMessage = RoundedCornerShape(16.dp).copy(bottomStart = CornerSize(0))

@Composable
fun TransactionDetailsScreen(viewState: TransactionViewState?) {
    if (viewState == null) return
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        Divider(
            thickness = 4.dp,
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .padding(8.dp)
                .align(CenterHorizontally)
                .clip(MaterialTheme.shapes.small)
        )

        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "account",
            modifier = Modifier
                .padding(28.dp)
                .size(120.dp)
                .align(CenterHorizontally)
                .background(KardMoneyBackground, CircleShape)
                .padding(20.dp),
        )

        Text(
            text = viewState.title,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .align(CenterHorizontally),
        )
        Text(
            text = viewState.description.uppercase(),
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(4.dp)
                .background(Color.LightGray, MaterialTheme.shapes.medium)
                .padding(8.dp),
        )

        Text(
            text = viewState.amount,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 16.dp, bottom = 40.dp),
        )

        Divider()
        Row {
            RoundedPicture(
                pictureUrl = viewState.emitterAvatarUrl,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            )

            Column {
                Text(
                    text = viewState.emitterName,
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(8.dp),
                )
                Text(
                    text = viewState.processedAt,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(horizontal = 8.dp),
                )
            }
        }
        Divider()

        viewState.comments.forEach {
            CommentView(it)
        }

        Spacer(modifier = Modifier.defaultMinSize(minHeight = 60.dp))
    }
}