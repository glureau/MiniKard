package com.glureau.minikard.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glureau.minikard.ext.formatCurrency
import java.math.BigDecimal


@Composable
fun HomeScreen() {
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.fillMaxSize()) {
        LazyColumn(Modifier.padding(12.dp)) {
            item {
                UserWelcomeBalance()
            }

            item {
                ActivateGooglePay()
            }

            item {
                Row(Modifier.padding(top = 16.dp, bottom=8.dp)) {
                    Text(text = "La semaine du 2 aout", modifier = Modifier.padding(start = 12.dp))
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = BigDecimal("1189.00").formatCurrency(),
                        modifier = Modifier.padding(end = 12.dp)
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = 10.dp
                ) {
                    Column {
                        UserBalanceEntry()
                        Divider()
                        UserBalanceEntry()
                        Divider()
                        UserBalanceEntry()
                        Divider()
                        UserBalanceEntry()
                        Divider()
                        UserBalanceEntry()
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}

@Preview(device = Devices.PIXEL_3A)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}