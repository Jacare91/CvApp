package jacare.io.cvapplication.bindings

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("isVisible")
fun setAdapter(view: View, isVisible: Boolean?) {
    isVisible?.let {
        view.visibility = if(isVisible) View.VISIBLE else View.GONE
    }
}