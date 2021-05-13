package com.vkpriesniakov.imaginesoft.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object KtorModule {

    @Singleton
    @Provides
    fun provideKtorClient(): HttpClient =
        HttpClient(Android) {
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
            engine {
                connectTimeout = 100_000
                socketTimeout = 100_000
            }
        }
}