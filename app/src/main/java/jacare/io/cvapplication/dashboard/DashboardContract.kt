package jacare.io.cvapplication.dashboard

import androidx.databinding.ObservableField
import jacare.io.cvapplication.domain.experience.ExperienceShortcut
import jacare.io.cvapplication.domain.skill.SkillShortcut
import jacare.io.cvapplication.model.skill.Skill

class DashboardContract {
    interface State {
        val skills: ObservableField<List<SkillShortcut>>
        val experiences: ObservableField<List<ExperienceShortcut>>
        val portrait: ObservableField<String?>
        val name: ObservableField<String>
        val role: ObservableField<String>
        val location: ObservableField<String>
        val shortBio: ObservableField<String>
    }

    interface ViewModel {
        fun initialize()
    }
}