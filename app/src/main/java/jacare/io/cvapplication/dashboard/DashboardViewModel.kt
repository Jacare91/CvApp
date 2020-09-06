package jacare.io.cvapplication.dashboard

import io.reactivex.disposables.Disposable
import jacare.io.cvapplication.domain.LoadProfileUsecase
import jacare.io.cvapplication.model.profile.PersonProfile
import jacare.io.cvapplication.model.profile.ProfileRepository
import jacare.io.cvapplication.model.skill.SkillRepository

class DashboardViewModel(
    private val state: DashboardContract.State,
    private val skillRepository: SkillRepository,
    private val profileRepository: ProfileRepository
) : DashboardContract.ViewModel {
    private var skillsLoadDisposable: Disposable? = null
    private var profileLoadDisposable: Disposable? = null

    override fun initialize() {
        skillsLoadDisposable = loadSkills()
        profileLoadDisposable = loadProfile()
    }

    private fun loadSkills() = skillRepository.fetchSkills()
        .subscribe { success, error ->
            if(error == null) {
                state.skills.set(success)
                skillsLoadDisposable?.dispose()
                skillsLoadDisposable = null
            }
        }

    private fun loadProfile() = profileRepository.fetchProfile()
        .execute()
        .subscribe { success, error ->
            if(error == null) {
                updateProfile(success)
                profileLoadDisposable?.dispose()
                profileLoadDisposable = null
            }
        }

    private fun updateProfile(profile: LoadProfileUsecase.Effect){
        state.portrait.set(profile.portraitUrl)
        state.name.set(profile.name)
        state.location.set(profile.location)
        state.role.set(profile.role)
        state.shortBio.set(profile.shortBio)
    }
}