package com.glureau.minikard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glureau.minikard.ext.formatCurrency
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat


@Composable
@Preview
fun UserWelcomeBalance(userName: String = "Basile", accountBalance: BigDecimal = BigDecimal("1862.39")) {
    Text(
        text = "Salut $userName \uD83D\uDC4B",
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(4.dp)
    )
    Column(modifier = Modifier.padding(4.dp)) {
        Text(text = "SOLDE ACTUEL", style = MaterialTheme.typography.body1)
        Text(text = accountBalance.formatCurrency(), style = MaterialTheme.typography.h1)
    }

    Row(modifier = Modifier.padding(4.dp)) {
        Button(
            onClick = { /*TODO*/ },
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "add",
                tint = Color.Green
            )
            Text(
                text = "Ajouter",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(start = 2.dp)
            )
        }

        Button(
            onClick = { /*TODO*/ },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.padding(start = 8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant
            )
        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowForward,
                contentDescription = "send",
                tint = Color.Cyan
            )
            Text(
                text = "Envoyer",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(start = 2.dp)
            )
        }
    }
}