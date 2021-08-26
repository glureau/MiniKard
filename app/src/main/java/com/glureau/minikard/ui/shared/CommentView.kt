package com.glureau.minikard.ui.shared

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class CommentViewState(
    val comment: String,
    val authorDetails: String,
    val authorPicture: String?,
)

@Composable
fun CommentView(viewState: CommentViewState) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 20.dp),
        shape = shapeMessage,
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = viewState.comment,
        )
    }
    Row(modifier = Modifier.padding(start = 16.dp, top = 2.dp)) {
        RoundedPicture(pictureUrl = viewState.authorPicture, modifier = Modifier.size(20.dp))
        Text(
            text = viewState.authorDetails,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}