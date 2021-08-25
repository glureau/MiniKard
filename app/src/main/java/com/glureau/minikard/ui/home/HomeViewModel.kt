package com.glureau.minikard.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glureau.minikard.data.TransactionDomain
import com.glureau.minikard.data.UserDomain
import com.glureau.minikard.di.Instances
import com.glureau.minikard.ext.formatCurrency
import com.glureau.minikard.ui.shared.TransactionViewState
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _viewState = MutableLiveData(HomeViewState())
    val viewState: LiveData<HomeViewState> = _viewState

    init {

        Log.e("GREG", "Client ready")
        viewModelScope.launch {
            val result = Instances.userRepository.userTransactions()
            if (result.isSuccess) {
                _viewState.postValue(result.getOrThrow().toViewState())
            } else {
                // TODO: Handle error screen
                _viewState.postValue(HomeViewState())
            }
        }
    }

    fun onDetailsClicked() {

    }
}

private fun UserDomain.toViewState() = HomeViewState(
    firstName = firstName,
    transactions = transactions.map {it.toViewState()}
)

private fun TransactionDomain.toViewState() = TransactionViewState(
    title = title ?: "No title",
    description = category ?: "No category",
    amount = amount.formatCurrency()
)