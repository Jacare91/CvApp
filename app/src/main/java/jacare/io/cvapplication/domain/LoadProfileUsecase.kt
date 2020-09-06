package jacare.io.cvapplication.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jacare.io.cvapplication.model.profile.ProfileApi

interface LoadProfileUsecase {
    class Effect(
        val name: String,
        val portraitUrl: String
    )

    fun execute(): Single<Effect>
}

class LoadProfileUsecaseImpl(private val api: ProfileApi) : LoadProfileUsecase {
    override fun execute(): Single<LoadProfileUsecase.Effect> {
        return api.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                LoadProfileUsecase.Effect(
                    it.name,
                    "profile/${it.portrait}"
                )
            }
    }

}