package jacare.io.cvapplication.view.experience

import io.reactivex.disposables.Disposable
import jacare.io.cvapplication.BuildConfig
import jacare.io.cvapplication.model.experience.ExperienceRepository

class ExperienceViewModel(
    private val state: ExperienceContract.State,
    private val repository: ExperienceRepository
) : ExperienceContract.ViewModel {
    private var loadExperienceDisposable: Disposable? = null

    override fun initialize(id: Long) {
        loadExperienceDisposable = repository.loadExperience(id)
            .subscribe { success, error ->
                if (error == null)
                    state.logoUrl.set("${BuildConfig.BASE_URL}${success.logoUrl}")
            }
    }
}