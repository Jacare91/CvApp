package jacare.io.cvapplication.app

import android.content.Context
import com.google.gson.Gson
import dagger.Component
import dagger.Module
import dagger.Provides
import jacare.io.cvapplication.BuildConfig
import jacare.io.cvapplication.dashboard.DashboardComponent
import jacare.io.cvapplication.dashboard.DashboardModule
import jacare.io.cvapplication.model.profile.ProfileRepository
import jacare.io.cvapplication.model.profile.ProfileRepositoryImpl
import jacare.io.cvapplication.model.skill.SkillRepository
import jacare.io.cvapplication.model.skill.SkillRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent{
    fun plus(module: DashboardModule): DashboardComponent
}

@Module
class AppModule(private val appContext: Context){
    @Provides
    @Singleton
    fun provideContext() = appContext

    @Provides
    @Singleton
    fun provideSkillsRepository(): SkillRepository =
        SkillRepositoryImpl()

    @Provides
    @Singleton
    fun provideProfileRepository(): ProfileRepository =
        ProfileRepositoryImpl()

    @Provides
    @Singleton
    fun provideConverterFactory(gson: Gson) = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
            )
        ).build()

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(converterFactory)
        .build()
}