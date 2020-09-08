package jacare.io.cvapplication.view.experience

import androidx.databinding.ObservableField
import jacare.io.cvapplication.domain.skill.SkillShortcut

class ExperienceContract {
    interface State{
        val logoUrl: ObservableField<String>
        val companyName: ObservableField<String>
        val roleName: ObservableField<String>
        val time: ObservableField<String>
        val description: ObservableField<String>
        val technologies: ObservableField<List<SkillShortcut>>
    }

    interface ViewModel{
        fun initialize(id: Long)
    }
}