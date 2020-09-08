package jacare.io.cvapplication.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import jacare.io.cvapplication.dashboard.ExperienceAdapter
import jacare.io.cvapplication.dashboard.SkillAdapter
import jacare.io.cvapplication.domain.experience.ExperienceShortcut
import jacare.io.cvapplication.domain.skill.SkillShortcut
import jacare.io.cvapplication.model.skill.Skill

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
    adapter?.let {
        view.adapter = adapter
    }
}

@BindingAdapter("items")
fun setSkills(view: RecyclerView, items: List<SkillShortcut>?) {
    items?.let {
        (view.adapter as? SkillAdapter)?.items = items.toMutableList()
    }
}

@BindingAdapter("items")
fun setExperiences(view: RecyclerView, items: List<ExperienceShortcut>?) {
    items?.let {
        (view.adapter as? ExperienceAdapter)?.items = items.toMutableList()
    }
}