package jacare.io.cvapplication.app

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import jacare.io.cvapplication.dashboard.DashboardComponent
import jacare.io.cvapplication.dashboard.DashboardModule
import jacare.io.cvapplication.model.profile.ProfileRepository
import jacare.io.cvapplication.model.profile.ProfileRepositoryImpl
import jacare.io.cvapplication.model.skill.SkillRepository
import jacare.io.cvapplication.model.skill.SkillRepositoryImpl
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
}