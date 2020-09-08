package jacare.io.cvapplication.view.experience

import androidx.databinding.ObservableField
import jacare.io.cvapplication.domain.skill.SkillShortcut

class ExperienceState(
    override val logoUrl: ObservableField<String> = ObservableField(),
    override val companyName: ObservableField<String> = ObservableField(),
    override val roleName: ObservableField<String> = ObservableField(),
    override val time: ObservableField<String> = ObservableField(),
    override val description: ObservableField<String> = ObservableField(),
    override val technologies: ObservableField<List<SkillShortcut>> = ObservableField()
) : ExperienceContract.State