package jacare.io.cvapplication.model.experience

import java.util.*

class ExperienceDetails(
    val id: Long,
    val logoUrl: String,
    val position: String,
    val companyName: String,
    val startDate: Date?,
    val endDate: Date?,
    val mainProduct: AppItem,
    val otherProducts: List<AppItem>
)

class AppItem(
    val name: String,
    val url: String
)