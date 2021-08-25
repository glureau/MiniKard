package com.glureau.minikard.ui.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ActivateGooglePay() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Activer Google Pay",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(8.dp),
            )
            Text(text = "Paye avec ton smartphone", modifier = Modifier.padding(8.dp))
        }
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "GooglePay",
            tint = Color.Green,
        )
    }
}