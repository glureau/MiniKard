package com.glureau.minikard.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.glureau.minikard.data.apollo.UserTransactionsQuery
import java.math.BigDecimal
import java.util.*

class UserRepository(private val apolloClient: ApolloClient) {
    suspend fun userTransactions(): Result<UserDomain> {
        //TODO: Extract logic and make a smart ext function for re-usability
        val response = try {
            apolloClient.query(UserTransactionsQuery()).await()
        } catch (e: ApolloException) {
            // handle protocol errors
            return Result.failure(e)
        }

        val content = response.data?.me

        if (content == null || response.hasErrors()) {
            return Result.failure(IllegalStateException(response.errors?.joinToString()))
        }

        return Result.success(content.toDomain())
    }
}

private fun UserTransactionsQuery.Me.toDomain() = UserDomain(
    firstName = this.profile?.firstName ?: "-",
    transactions = this.typedTransactions?.edges?.mapNotNull { it?.node?.toDomain() } ?: emptyList()
)

private fun UserTransactionsQuery.Node.toDomain() = TransactionDomain(
    id = id,
    title = title,
    category = category?.name,
    amount = this.amount!!.toDomain()// Let's consider a Transaction always have an amount...
)

private fun UserTransactionsQuery.Amount.toDomain() = MoneyDomain(
    amount = BigDecimal(String.format(Locale.ROOT, "%.2f", value)),
    currencyIsoCode = currency!!.isoCode, // Let's consider a Money always have a currency...
)