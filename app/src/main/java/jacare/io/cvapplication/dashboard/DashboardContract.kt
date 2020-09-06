package jacare.io.cvapplication.dashboard

import androidx.databinding.ObservableField
import jacare.io.cvapplication.model.skill.Skill

class DashboardContract {
    interface State {
        val skills: ObservableField<List<Skill>>
        val portrait: ObservableField<String?>
    }

    interface ViewModel {
        fun initialize()
    }
}