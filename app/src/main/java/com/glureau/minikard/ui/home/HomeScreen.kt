package com.glureau.minikard.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.glureau.minikard.ui.shared.ActivateGooglePay
import com.glureau.minikard.ui.shared.TransactionView
import com.glureau.minikard.ui.shared.UserWelcomeBalance


@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val viewState by viewModel.viewState.observeAsState()
    if (viewState != null)
        Surface(color = MaterialTheme.colors.primary, modifier = Modifier.fillMaxSize()) {
            LazyColumn(Modifier.padding(horizontal = 12.dp)) {
                item {
                    UserWelcomeBalance(firstName = viewState!!.firstName)
                }

                item {
                    ActivateGooglePay()
                }

                item {
                    Row(Modifier.padding(top = 16.dp, bottom = 8.dp)) {
                        Text(
                            text = "La semaine du 2 aout",
                            modifier = Modifier.padding(start = 12.dp)
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = "1189,00 €",
                            modifier = Modifier.padding(end = 12.dp)
                        )
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        elevation = 10.dp
                    ) {
                        Column {
                            viewState!!.transactions.forEachIndexed { index, transactionViewState ->
                                TransactionView(transactionViewState)
                                if (index < viewState!!.transactions.lastIndex )
                                    Divider()
                            }
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