package jacare.io.cvapplication.domain.skill

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jacare.io.cvapplication.BuildConfig
import jacare.io.cvapplication.model.skill.SkillsApi

interface LoadSkillsUsecase {
    class Effect(
        val name: String,
        val portraitUrl: String,
        val role: String,
        val location: String,
        val shortBio: String
    )

    fun execute(): Single<List<SkillShortcut>>
}

class LoadSkillsUsecaseImpl(
    private val api: SkillsApi
): LoadSkillsUsecase {
    override fun execute(): Single<List<SkillShortcut>> {
        return api.getSkills()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { list ->
                Observable.fromIterable(list)
                    .map {
                        SkillShortcut(it.name, "${BuildConfig.BASE_URL}${it.icon}", "")
                    }.toList()
            }
    }

}