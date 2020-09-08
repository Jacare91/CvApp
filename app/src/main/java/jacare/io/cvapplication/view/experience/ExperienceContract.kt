package jacare.io.cvapplication.view.experience

import androidx.databinding.ObservableField

class ExperienceContract {
    interface State{
        val logoUrl: ObservableField<String>
    }

    interface ViewModel{
        fun initialize(id: Long)
    }
}