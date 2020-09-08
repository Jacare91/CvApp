package jacare.io.cvapplication.view.experience

import android.util.Log
import jacare.io.cvapplication.model.experience.ExperienceRepository

class ExperienceViewModel(
    private val repository: ExperienceRepository
): ExperienceContract.ViewModel {
    override fun initialize(id: Long) {
        repository.loadExperience(id)
            .subscribe { success, error ->
                    Log.d("", "")
            }
    }
}