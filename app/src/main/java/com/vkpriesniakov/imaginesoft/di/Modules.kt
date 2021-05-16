package com.vkpriesniakov.imaginesoft.di

import com.vkpriesniakov.imaginesoft.network.retrofit.FlickrService
import com.vkpriesniakov.imaginesoft.utils.API_FLICKR
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.json.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object KtorModule {

    @Singleton
    @Provides
    fun provideKtorClient(): HttpClient =
        HttpClient(OkHttp) {
            install(JsonFeature) {

                serializer = GsonSerializer()
//                serializer = KotlinxSerializer()

            }
            engine {

            }
        }
}


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(API_FLICKR)
            .client(provideOkhttp())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideOkhttp(): OkHttpClient {
        val client = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return client.addInterceptor(logging).build()
    }

    @Singleton
    @Provides
    fun provideService(): FlickrService =
        provideRetrofit().create(FlickrService::class.java)

}
