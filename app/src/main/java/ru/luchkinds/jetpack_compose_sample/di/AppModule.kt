package ru.luchkinds.jetpack_compose_sample.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
// import retrofit2.converter.gson.GsonConverterFactory
import ru.luchkinds.jetpack_compose_sample.data.db.AppDatabase
import ru.luchkinds.jetpack_compose_sample.data.remote.SampleRemote
import ru.luchkinds.jetpack_compose_sample.data.services.SampleService
import ru.luchkinds.jetpack_compose_sample.domain.services.ISampleService

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        // .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    @Provides
    @Singleton
    fun provideSampleRemote(retrofit: Retrofit): SampleRemote = retrofit.create(SampleRemote::class.java)

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext applicationContext: Context) = Room.databaseBuilder(
        context = applicationContext,
        klass = AppDatabase::class.java,
        name = "database.db",
    )
        .createFromAsset("room_article.db")
        .build()

    @Provides
    @Singleton
    fun provideSampleService(remote: SampleRemote): ISampleService {
        return SampleService(remote)
    }
}