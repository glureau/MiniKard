package com.glureau.minikard.di

import com.apollographql.apollo.ApolloClient
import com.glureau.minikard.data.UserRepository
import com.glureau.minikard.ui.home.HomeViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        OkHttpClient.Builder()
            .addNetworkInterceptor {
                val newRequest = it.request().newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwZTU5ODRhNi1mYjgxLTQwNzgtOGFjNi1jY2U1ZjFiNDZkNzQiLCJzdWIiOiJkZTdhMjA2OC1lMWNlLTQwZWEtOGRlMC04MDZiYWYyYzM2OTAiLCJzY3AiOiJ1c2VyIiwiYXVkIjpudWxsLCJpYXQiOjE2Mjk4MTkyMTAsImV4cCI6MTYzMDQyNDAxMH0.J4VNuptn7h5pI1bzVy4E_UUTRK6qJwE9TZksaXJ_24g"
                    )
                    .build()
                it.proceed(newRequest)
            }.build()
    }

    single {
        ApolloClient.builder()
            .serverUrl("https://staging.kard.eu/graphql/")
            .okHttpClient(get())
            .build()
    }

    single { UserRepository(get()) }

    viewModel { HomeViewModel(get()) }
}