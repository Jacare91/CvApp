package jacare.io.cvapplication.model.experience

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jacare.io.cvapplication.domain.experience.ExperienceShortcut
import java.text.SimpleDateFormat
import java.util.*

interface ExperienceRepository {
    fun loadExperiencesList(): Single<List<ExperienceShortcut>>
    fun loadExperience(id: Long): Single<ExperienceDetails>
}

class ExperienceRepositoryImpl(private val api: ExperienceApi) : ExperienceRepository {
    override fun loadExperiencesList() = api.getExperiences()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { response ->
            val dateFormat = SimpleDateFormat("mm.YYYY", Locale.getDefault())
            Observable.fromIterable(response)
                .map { exp ->
                    val positionString = "${exp.position}, ${exp.companyName}"
                    val startPeriod = dateFormat.format(exp.startDate)
                    val endPeriod = dateFormat.format(exp.endDate)
                    ExperienceShortcut(exp.id, positionString, "$startPeriod - $endPeriod")
                }.toList()
        }

    override fun loadExperience(id: Long) = api.getExperience(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}