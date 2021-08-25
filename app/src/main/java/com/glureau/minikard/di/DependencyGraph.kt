package com.glureau.minikard.di

import com.apollographql.apollo.ApolloClient
import com.glureau.minikard.data.UserRepository
import okhttp3.OkHttpClient

// TODO: Koin
object Instances {
    val okhttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor {
            val newRequest = it.request().newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwZTU5ODRhNi1mYjgxLTQwNzgtOGFjNi1jY2U1ZjFiNDZkNzQiLCJzdWIiOiJkZTdhMjA2OC1lMWNlLTQwZWEtOGRlMC04MDZiYWYyYzM2OTAiLCJzY3AiOiJ1c2VyIiwiYXVkIjpudWxsLCJpYXQiOjE2Mjk4MTkyMTAsImV4cCI6MTYzMDQyNDAxMH0.J4VNuptn7h5pI1bzVy4E_UUTRK6qJwE9TZksaXJ_24g"
                )
                .build()
            it.proceed(newRequest)
        }.build()

    val apolloClient = ApolloClient.builder()
        .serverUrl("https://staging.kard.eu/graphql/")
        .okHttpClient(okhttpClient)
        .build()

    val userRepository = UserRepository(apolloClient)
}