package com.glureau.minikard.ui.shared

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glureau.minikard.ext.formatCurrency
import com.glureau.minikard.ui.theme.KardMoneyBackground
import java.math.BigDecimal
import kotlin.random.Random

data class TransactionViewState(
    val title: String,
    val description: String,
    val amount: String,
)

@Composable
@Preview
fun TransactionView(
    viewState: TransactionViewState =
        TransactionViewState("Rechargement", "Rechargement", "70,00 €")
) {
    Row(Modifier.padding(12.dp)) {
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