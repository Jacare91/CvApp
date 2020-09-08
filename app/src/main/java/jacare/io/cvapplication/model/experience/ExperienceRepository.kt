package jacare.io.cvapplication.model.experience

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jacare.io.cvapplication.domain.experience.ExperienceShortcut
import java.text.SimpleDateFormat
import java.util.*

interface ExperienceRepository {
    fun loadExperiences(): Single<List<ExperienceShortcut>>
}

class ExperienceRepositoryImpl(private val api: ExperienceApi) : ExperienceRepository {
    override fun loadExperiences() = api.getExperiences()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { response ->
            val dateFormat = SimpleDateFormat("mm.YYYY", Locale.getDefault())
            Observable.fromIterable(response)
                .map { exp ->
                    val positionString = "${exp.position}, ${exp.companyName}"
                    val startPeriod = exp.startDate?.let { dateFormat.format(it) } ?: ""
                    val endPeriod = exp.endDate?.let { dateFormat.format(it) } ?: ""
                    ExperienceShortcut(positionString, "$startPeriod - $endPeriod")
                }.toList()
        }
}