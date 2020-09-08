package jacare.io.cvapplication.model.experience

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ExperienceApi {
    @GET("experiences/experiences.json")
    fun getExperiences(): Single<List<ExperienceListItem>>

    @GET("experiences/{id}.json")
    fun getExperience(@Path("id") id: Long): Single<ExperienceDetails>
}