package com.glureau.minikard.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.glureau.minikard.ui.shared.*
import org.koin.androidx.compose.getViewModel


@ExperimentalMaterialApi
@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {
    val viewState = viewModel.viewState.observeAsState().value ?: return

    BottomSheet(
        target = viewState.selectedTransaction,
        content = {
            Surface(color = MaterialTheme.colors.primary, modifier = Modifier.fillMaxSize()) {
                LazyColumn(Modifier.padding(horizontal = 12.dp)) {
                    item {
                        UserWelcomeBalance(
                            firstName = viewState.firstName,
                            accountBalance = viewState.balance
                        )
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
                            modifier = Modifier.fillMaxWidth(),
                            elevation = 10.dp
                        ) {
                            Column {
                                viewState.transactions.forEachIndexed { index, transactionViewState ->
                                    TransactionView(transactionViewState) {
                                        viewModel.onTransactionClicked(it)
                                    }
                                    if (index < viewState.transactions.lastIndex)
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
        },
        sheetContent = {
            TransactionDetailsScreen(viewState.selectedTransaction)
        },
        onClose = viewModel::onTransactionDetailsClosed
    )
}