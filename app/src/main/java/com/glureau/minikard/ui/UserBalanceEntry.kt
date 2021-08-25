package com.glureau.minikard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
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

data class UserBalanceEntryViewState(
    val title: String,
    val description: String,
    val amount: BigDecimal,
)

@Composable
@Preview
fun UserBalanceEntry(
    viewState: UserBalanceEntryViewState =
        UserBalanceEntryViewState("Rechargement", "Rechargement", BigDecimal(Random.nextInt(70)))
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
            Text(text = viewState.description)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = viewState.amount.formatCurrency(),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp)
        )
    }
}