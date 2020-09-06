package jacare.io.cvapplication.model.skill

import io.reactivex.Single

interface SkillRepository {
    fun fetchSkills(): Single<List<Skill>>
}

class SkillRepositoryImpl : SkillRepository {
    override fun fetchSkills(): Single<List<Skill>> {
        return Single.just(
            listOf(
                Skill(
                    "Android",
                    "https://raw.githubusercontent.com/Jacare91/CvApp/master/icons/Android-Logo.png",
                    ""
                ),
                Skill(
                    "GIT",
                    "https://raw.githubusercontent.com/Jacare91/CvApp/master/icons/Git-Icon-1788C.png",
                    ""
                ),
                Skill(
                    "RxJava",
                    "https://raw.githubusercontent.com/Jacare91/CvApp/master/icons/RxJava-Logo.png",
                    ""
                ),
                Skill(
                    "Kotlin",
                    "https://raw.githubusercontent.com/Jacare91/CvApp/master/icons/RxJava-Logo.png",
                    ""
                ),
                Skill(
                    "Java",
                    "https://raw.githubusercontent.com/Jacare91/CvApp/master/icons/RxJava-Logo.png",
                    ""
                ),
                Skill(
                    "Scrum",
                    "https://raw.githubusercontent.com/Jacare91/CvApp/master/icons/RxJava-Logo.png",
                    ""
                )
            )
        )
    }
}