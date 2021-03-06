package jacare.io.cvapplication.view.experience

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import jacare.io.cvapplication.model.experience.ExperienceRepository
import jacare.io.cvapplication.model.profile.ProfileRepository
import jacare.io.cvapplication.model.skill.SkillRepository
import jacare.io.cvapplication.scopes.ActivityScope
import jacare.io.cvapplication.view.dashboard.SkillAdapter

@Subcomponent(modules = [ExperienceModule::class])
@ActivityScope
interface ExperienceComponent {
    fun inject(activity: ExperienceActivity)
}

@Module
class ExperienceModule {
    @Provides
    @ActivityScope
    fun provideSkillsAdapter() = SkillAdapter()

    @Provides
    @ActivityScope
    fun provideExperienceState(): ExperienceContract.State = ExperienceState()

    @Provides
    @ActivityScope
    fun provideExperienceViewModel(
        state: ExperienceContract.State,
        experienceRepository: ExperienceRepository
    ): ExperienceContract.ViewModel =
        ExperienceViewModel(state, experienceRepository)
}