package jacare.io.cvapplication.view.dashboard

import androidx.databinding.ObservableField
import jacare.io.cvapplication.domain.experience.ExperienceShortcut
import jacare.io.cvapplication.domain.skill.SkillShortcut
import jacare.io.cvapplication.model.skill.Skill

class DashboardState(
    override val skills: ObservableField<List<SkillShortcut>> = ObservableField(),
    override val portrait: ObservableField<String?> = ObservableField(""),
    override val name: ObservableField<String> = ObservableField(""),
    override val role: ObservableField<String> = ObservableField(""),
    override val location: ObservableField<String> = ObservableField(""),
    override val shortBio: ObservableField<String> = ObservableField(""),
    override val experiences: ObservableField<List<ExperienceShortcut>> = ObservableField()
) : DashboardContract.State {
}