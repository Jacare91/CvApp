package jacare.io.cvapplication.view.experience

import androidx.databinding.ObservableField

class ExperienceState(
    override val logoUrl: ObservableField<String> = ObservableField(),
    override val companyName: ObservableField<String> = ObservableField(),
    override val roleName: ObservableField<String> = ObservableField(),
    override val time: ObservableField<String> = ObservableField(),
    override val description: ObservableField<String> = ObservableField()
) : ExperienceContract.State