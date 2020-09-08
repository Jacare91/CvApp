package jacare.io.cvapplication.model.skill

import io.reactivex.Single
import retrofit2.http.GET

interface SkillsApi {
    @GET("profile/profile_skills.json")
    fun getSkills(): Single<List<Skill>>
}