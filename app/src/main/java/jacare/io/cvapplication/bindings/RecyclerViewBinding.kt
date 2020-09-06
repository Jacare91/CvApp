package jacare.io.cvapplication.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import jacare.io.cvapplication.dashboard.SkillAdapter
import jacare.io.cvapplication.model.skill.Skill

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: SkillAdapter?) {
    adapter?.let {
        view.adapter = adapter
    }
}

@BindingAdapter("items")
fun setItems(view: RecyclerView, items: List<Skill>?) {
    items?.let {
        (view.adapter as? SkillAdapter)?.items = items.toMutableList()
    }
}