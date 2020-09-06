package jacare.io.cvapplication.model.profile

import io.reactivex.Single
import retrofit2.http.GET

interface ProfileApi {
    @GET("profile/profile.json")
    fun getProfile(): Single<PersonProfile>
}