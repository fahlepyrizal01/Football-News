package com.fahlepyrizal01.core.di

import androidx.room.Room
import com.fahlepyrizal01.core.BuildConfig
import com.fahlepyrizal01.core.data.FootballRepository
import com.fahlepyrizal01.core.data.source.local.FootballLocalDataSource
import com.fahlepyrizal01.core.data.source.local.IFootballLocalSource
import com.fahlepyrizal01.core.data.source.local.room.FootballDatabase
import com.fahlepyrizal01.core.data.source.remote.FootballRemoteDataSource
import com.fahlepyrizal01.core.data.source.remote.IFootballRemoteSource
import com.fahlepyrizal01.core.data.source.remote.network.ApiService
import com.fahlepyrizal01.core.domain.repository.IFootballRepository
import com.fahlepyrizal01.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val databaseModule = module {
    factory { get<FootballDatabase>().footballDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            FootballDatabase::class.java, "Football.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val localDataSourceModule = module {
    single <IFootballLocalSource> {
        FootballLocalDataSource(get())
    }
}
val remoteDataSourceModule = module {
    single <IFootballRemoteSource> {
        FootballRemoteDataSource(get())
    }
}

val repositoryModule = module {
    single { FootballLocalDataSource(get()) }
    single { FootballRemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IFootballRepository> {
        FootballRepository(get(), get(), get())
    }
}