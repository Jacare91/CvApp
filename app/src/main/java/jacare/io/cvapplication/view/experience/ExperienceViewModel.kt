package jacare.io.cvapplication.view.experience

import io.reactivex.disposables.Disposable
import jacare.io.cvapplication.BuildConfig
import jacare.io.cvapplication.domain.experience.ExperienceShortcut
import jacare.io.cvapplication.model.experience.ExperienceRepository
import java.text.SimpleDateFormat
import java.util.*

class ExperienceViewModel(
    private val state: ExperienceContract.State,
    private val repository: ExperienceRepository
) : ExperienceContract.ViewModel {
    private var loadExperienceDisposable: Disposable? = null

    override fun initialize(id: Long) {
        loadExperienceDisposable = repository.loadExperience(id)
            .subscribe { success, error ->
                if (error == null) {
                    val url = "${BuildConfig.BASE_URL}${success.logoUrl}"
                    val dateFormat = SimpleDateFormat("mm.YYYY", Locale.getDefault())
                    val startPeriod = dateFormat.format(success.startDate)
                    val endPeriod = dateFormat.format(success.endDate)
                    val timespan = "$startPeriod - $endPeriod"

                    state.logoUrl.set(url)
                    state.companyName.set(success.companyName)
                    state.roleName.set(success.position)
                    state.time.set(timespan)
                    state.description.set(success.description)
                }
            }
    }
}