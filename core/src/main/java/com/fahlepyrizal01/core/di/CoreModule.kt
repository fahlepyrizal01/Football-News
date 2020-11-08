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
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
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
        val passphrase: ByteArray = SQLiteDatabase.getBytes(BuildConfig.ENCRYPT_PASSWORD.toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            FootballDatabase::class.java, BuildConfig.DATABSE_NAME
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val certificatePinner = CertificatePinner.Builder()
            .add(BuildConfig.HOST_NAME, BuildConfig.FIRST_CERTIFICATE)
            .add(BuildConfig.HOST_NAME, BuildConfig.SECOND_CERTIFICATE)
            .add(BuildConfig.HOST_NAME, BuildConfig.THIRD_CERTIFICATE)
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("${BuildConfig.BASE_URL}${BuildConfig.API_PATH}${BuildConfig.TSDB_API_KEY}/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val localDataSourceModule = module {
    single<IFootballLocalSource> {
        FootballLocalDataSource(get())
    }
}
val remoteDataSourceModule = module {
    single<IFootballRemoteSource> {
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