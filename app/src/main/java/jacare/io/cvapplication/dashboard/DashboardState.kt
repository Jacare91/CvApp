package jacare.io.cvapplication.dashboard

import androidx.databinding.ObservableField
import jacare.io.cvapplication.model.skill.Skill

class DashboardState(
    override val skills: ObservableField<List<Skill>> = ObservableField(),
    override val portrait: ObservableField<String?> = ObservableField("")
) : DashboardContract.State {
}