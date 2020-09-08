package jacare.io.cvapplication.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jacare.io.cvapplication.model.skill.Skill
import jacare.io.cvapplication.databinding.ItemSkillBinding
import jacare.io.cvapplication.domain.skill.SkillShortcut

class SkillAdapter : RecyclerView.Adapter<SkillViewHolder>() {
    var items = mutableListOf<SkillShortcut>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSkillBinding.inflate(inflater, parent, false)
        return SkillViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}

class SkillViewHolder(val binding: ItemSkillBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: SkillShortcut){
        binding.iconUrl = item.iconUrl
        binding.nameText = item.name
        binding.executePendingBindings()
    }
}