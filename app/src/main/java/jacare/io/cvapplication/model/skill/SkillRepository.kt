package jacare.io.cvapplication.model.skill

import io.reactivex.Single
import jacare.io.cvapplication.domain.skill.LoadSkillsUsecaseImpl
import jacare.io.cvapplication.domain.skill.SkillShortcut

interface SkillRepository {
    fun fetchSkills(): Single<List<SkillShortcut>>
}

class SkillRepositoryImpl(
    private val api: SkillsApi
) : SkillRepository {
    override fun fetchSkills(): Single<List<SkillShortcut>> {
        return LoadSkillsUsecaseImpl(api).execute()
    }
}