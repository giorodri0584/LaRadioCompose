package com.rodriguez.giomar.laradio.di

import com.rodriguez.giomar.laradio.other.Constants.APP_ID
import com.rodriguez.giomar.laradio.other.Constants.REST_KEY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun httClient() = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        defaultRequest {
            header("X-Parse-Application-Id", APP_ID)
            header("X-Parse-REST-API-Key", REST_KEY)
        }
    }

    @Singleton
    @Provides
    fun a
}