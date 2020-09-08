package jacare.io.cvapplication.app

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Component
import dagger.Module
import dagger.Provides
import jacare.io.cvapplication.BuildConfig
import jacare.io.cvapplication.view.dashboard.DashboardComponent
import jacare.io.cvapplication.view.dashboard.DashboardModule
import jacare.io.cvapplication.model.experience.ExperienceApi
import jacare.io.cvapplication.model.experience.ExperienceRepository
import jacare.io.cvapplication.model.experience.ExperienceRepositoryImpl
import jacare.io.cvapplication.model.profile.ProfileApi
import jacare.io.cvapplication.model.profile.ProfileRepository
import jacare.io.cvapplication.model.profile.ProfileRepositoryImpl
import jacare.io.cvapplication.model.skill.Skill
import jacare.io.cvapplication.model.skill.SkillRepository
import jacare.io.cvapplication.model.skill.SkillRepositoryImpl
import jacare.io.cvapplication.model.skill.SkillsApi
import jacare.io.cvapplication.view.experience.ExperienceComponent
import jacare.io.cvapplication.view.experience.ExperienceModule
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
    fun plus(module: ExperienceModule): ExperienceComponent
}

@Module
class AppModule(private val appContext: Context){
    @Provides
    @Singleton
    fun provideContext() = appContext

    @Provides
    @Singleton
    fun provideExperienceRepository(
        api: ExperienceApi
    ): ExperienceRepository = ExperienceRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideExperienceApi(retrofit: Retrofit): ExperienceApi = retrofit.create(ExperienceApi::class.java)

    @Provides
    @Singleton
    fun provideSkillsRepository(
        api: SkillsApi
    ): SkillRepository = SkillRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideSkillsApi(retrofit: Retrofit): SkillsApi = retrofit.create(SkillsApi::class.java)

    @Provides
    @Singleton
    fun provideProfileRepository(profileApi: ProfileApi): ProfileRepository =
        ProfileRepositoryImpl(profileApi)

    @Provides
    @Singleton
    fun provideProfileApi(retrofit: Retrofit): ProfileApi = retrofit.create(ProfileApi::class.java)

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
        .setDateFormat("mm.YYYY")
        .create()

    @Provides
    @Singleton
    fun provideConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
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
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(converterFactory)
        .build()
}