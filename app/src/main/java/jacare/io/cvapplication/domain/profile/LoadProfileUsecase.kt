package jacare.io.cvapplication.domain.profile

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jacare.io.cvapplication.BuildConfig
import jacare.io.cvapplication.model.profile.ProfileApi

interface LoadProfileUsecase {
    class Effect(
        val name: String,
        val portraitUrl: String,
        val role: String,
        val location: String,
        val shortBio: String
    )

    fun execute(): Single<Effect>
}

class LoadProfileUsecaseImpl(private val api: ProfileApi) :
    LoadProfileUsecase {
    override fun execute(): Single<LoadProfileUsecase.Effect> {
        return api.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                LoadProfileUsecase.Effect(
                    it.name,
                    "${BuildConfig.BASE_URL}/profile/${it.portrait}",
                    it.role,
                    "${it.city}, ${it.country}",
                    it.shortBio
                )
            }
    }

}