package com.glureau.minikard.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glureau.minikard.android.SingleLiveEvent
import com.glureau.minikard.data.CommentDomain
import com.glureau.minikard.data.TransactionDomain
import com.glureau.minikard.data.UserDomain
import com.glureau.minikard.di.Instances
import com.glureau.minikard.ext.formatCurrency
import com.glureau.minikard.ui.shared.CommentViewState
import com.glureau.minikard.ui.shared.TransactionViewState
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

class HomeViewModel : ViewModel() {
    private var currentViewState: HomeViewState = HomeViewState()
    private val _viewState = MutableLiveData(currentViewState)
    val viewState: LiveData<HomeViewState> = _viewState

    private val _viewEffects: SingleLiveEvent<HomeViewEffect> = SingleLiveEvent()
    fun viewEffects(): SingleLiveEvent<HomeViewEffect> = _viewEffects

    init {

        Log.e("GREG", "Client ready")
        viewModelScope.launch {
            val result = Instances.userRepository.userTransactions()
            currentViewState = if (result.isSuccess) {
                result.getOrThrow().toViewState()
            } else {
                // TODO: Handle error screen
                HomeViewState()
            }
            _viewState.postValue(currentViewState)
        }
    }

    fun onTransactionClicked(transactionViewState: TransactionViewState) {
        currentViewState = currentViewState.copy(selectedTransaction = transactionViewState)
        _viewState.postValue(currentViewState)
    }

    fun onTransactionDetailsClosed() {
        currentViewState = currentViewState.copy(selectedTransaction = null)
        _viewState.postValue(currentViewState)
    }
}

private fun UserDomain.toViewState() = HomeViewState(
    firstName = firstName,
    balance = balance.formatCurrency(),
    transactions = transactions.map { it.toViewState() },
)

private fun TransactionDomain.toViewState() = TransactionViewState(
    id = id,
    title = title ?: "No title",
    description = category ?: "No category",
    amount = amount.formatCurrency(),
    emitterName = emitterName,
    emitterAvatarUrl = emitterAvatarUrl,
    processedAt = SimpleDateFormat("d MMMM yyyy 'à' H'h'mm").format(processedAt),
    comments = comments.map { it.toViewState() }
)

private fun CommentDomain.toViewState() = CommentViewState(
    comment = content ?: "-",
    authorPicture = authorAvatarUrl,
    authorDetails = "$authorFirstName $authorLastName, " +
            "le ${SimpleDateFormat("d MMMM yyyy").format(createdAt)}"
)