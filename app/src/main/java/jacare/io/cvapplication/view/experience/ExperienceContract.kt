package jacare.io.cvapplication.view.experience

import androidx.databinding.ObservableField
import io.reactivex.Observable
import jacare.io.cvapplication.domain.skill.SkillShortcut

class ExperienceContract {
    interface State {
        val logoUrl: ObservableField<String>
        val companyName: ObservableField<String>
        val roleName: ObservableField<String>
        val time: ObservableField<String>
        val description: ObservableField<String>
        val technologies: ObservableField<List<SkillShortcut>>
        val productNameDescription: ObservableField<String>
        var productPackage: String
    }

    interface ViewModel {
        val openStore: Observable<Pair<String, String>>

        fun initialize(id: Long)
        fun viewProduct()
    }
}