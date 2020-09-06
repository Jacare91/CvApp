package jacare.io.cvapplication.dashboard

import io.reactivex.disposables.Disposable
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
        .subscribe { success, error ->
            if(error == null) {
                state.portrait.set(success.portrait)
                profileLoadDisposable?.dispose()
                profileLoadDisposable = null
            }
        }
}