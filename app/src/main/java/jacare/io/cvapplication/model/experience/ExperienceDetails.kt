package jacare.io.cvapplication.model.experience

import jacare.io.cvapplication.model.skill.Skill
import java.util.*

class ExperienceDetails(
    val id: Long,
    val logoUrl: String,
    val position: String,
    val companyName: String,
    val startDate: Date,
    val endDate: Date,
    val description: String,
    val productAvailable: Boolean,
    val mainProduct: AppItem,
    val otherProducts: List<AppItem>,
    val technologies: List<Skill>
)

class AppItem(
    val name: String,
    val packageName: String
)