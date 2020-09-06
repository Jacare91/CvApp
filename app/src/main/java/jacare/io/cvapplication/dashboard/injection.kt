package jacare.io.cvapplication.dashboard

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import jacare.io.cvapplication.model.profile.ProfileRepository
import jacare.io.cvapplication.scopes.ActivityScope
import jacare.io.cvapplication.model.skill.SkillRepository

@Subcomponent(modules = [DashboardModule::class])
@ActivityScope
interface DashboardComponent {
    fun inject(activity: DashboardActivity)
}

@Module
class DashboardModule {
    @Provides
    @ActivityScope
    fun provideSkillAdapter() = SkillAdapter()

    @Provides
    @ActivityScope
    fun provideDashboardState(): DashboardContract.State = DashboardState()

    @Provides
    @ActivityScope
    fun provideDashboardViewModel(
        state: DashboardContract.State,
        skillRepository: SkillRepository,
        profileRepository: ProfileRepository
    ): DashboardContract.ViewModel = DashboardViewModel(state, skillRepository, profileRepository)
}