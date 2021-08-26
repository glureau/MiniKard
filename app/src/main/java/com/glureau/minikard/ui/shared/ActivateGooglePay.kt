package com.glureau.minikard.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glureau.minikard.R

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
                modifier = Modifier.padding(4.dp),
            )
            Text(text = "Paye avec ton smartphone", modifier = Modifier.padding(8.dp))
        }
        Spacer(Modifier.weight(1f))
        Image(painterResource(id = R.drawable.gpay),"GooglePay")
    }
}