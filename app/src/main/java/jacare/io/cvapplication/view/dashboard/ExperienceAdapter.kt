package jacare.io.cvapplication.view.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import jacare.io.cvapplication.databinding.ItemExperienceBinding
import jacare.io.cvapplication.domain.experience.ExperienceShortcut

class ExperienceAdapter : RecyclerView.Adapter<ExperienceViewHolder>() {
    private val _onClick = PublishSubject.create<Long>()
    val onClick: Observable<Long>
        get() = _onClick

    var items = mutableListOf<ExperienceShortcut>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemExperienceBinding.inflate(inflater, parent, false)
        return ExperienceViewHolder(
            binding
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            _onClick.onNext(item.id)
        }
    }
}

class ExperienceViewHolder(
    val binding: ItemExperienceBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ExperienceShortcut) {
        binding.roleString = item.description
        binding.timeString = item.timeSpan
    }
}