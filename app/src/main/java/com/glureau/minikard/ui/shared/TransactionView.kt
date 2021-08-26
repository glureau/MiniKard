package com.glureau.minikard.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.glureau.minikard.ui.theme.KardMoneyBackground

data class TransactionViewState(
    val id: String = "-",
    val title: String = "-",
    val description: String = "-",
    val amount: String = "-",
    val emitterName: String = "-",
    val emitterAvatarUrl: String? = "-",
    val processedAt: String = "-",
    val comments: List<CommentViewState> = emptyList(),
)

@Composable
fun TransactionView(
    viewState: TransactionViewState,
    onClick: (TransactionViewState) -> Unit = {}
) {
    Row(
        Modifier
            .clickable { onClick(viewState) }
            .padding(12.dp)) {
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "account",
            modifier = Modifier
                .size(80.dp)
                .background(KardMoneyBackground, CircleShape)
                .padding(12.dp),
        )
        Column(
            Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 12.dp)
        ) {
            Text(text = viewState.title)
            Text(text = viewState.description, style = MaterialTheme.typography.body2)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = viewState.amount,
            maxLines = 1,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp)
        )
    }
}