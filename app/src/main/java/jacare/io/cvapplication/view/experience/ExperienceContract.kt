package jacare.io.cvapplication.view.experience

import androidx.databinding.ObservableField

class ExperienceContract {
    interface State{
        val logoUrl: ObservableField<String>
        val companyName: ObservableField<String>
        val roleName: ObservableField<String>
        val time: ObservableField<String>
        val description: ObservableField<String>
    }

    interface ViewModel{
        fun initialize(id: Long)
    }
}