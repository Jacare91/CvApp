package jacare.io.cvapplication.view.experience

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import jacare.io.cvapplication.BuildConfig
import jacare.io.cvapplication.domain.skill.SkillShortcut
import jacare.io.cvapplication.model.experience.ExperienceRepository
import java.text.SimpleDateFormat
import java.util.*

class ExperienceViewModel(
    private val state: ExperienceContract.State,
    private val repository: ExperienceRepository
) : ExperienceContract.ViewModel {
    private var loadExperienceDisposable: Disposable? = null

    private val _openStore = PublishSubject.create<Pair<String, String>>()
    override val openStore: Observable<Pair<String, String>>
        get() = _openStore

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
                    state.technologies.set(success.technologies.map {
                        SkillShortcut(it.name, "", "")
                    })

                    state.displayProduct.set(success.productAvailable)

                    if (success.productAvailable) {
                        state.productNameDescription.set("The product I was working on was named ${success.mainProduct.name}")
                        state.productPackage = success.mainProduct.packageName
                    }
                }
            }
    }

    override fun viewProduct() {
        val storeUrl = "market://details?id=${state.productPackage}"
        val default = "https://play.google.com/store/apps/details?id=${state.productPackage}"
        _openStore.onNext(Pair(storeUrl, default))
    }
}