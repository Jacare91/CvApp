package jacare.io.cvapplication.model.experience

import io.reactivex.Single
import retrofit2.http.GET

interface ExperienceApi {
    @GET("experiences/experiences.json")
    fun getExperiences(): Single<List<Experience>>
}