package jacare.io.cvapplication.bindings

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

@BindingAdapter("url")
fun setImageUrl(drawee: SimpleDraweeView, url: String?){
    url?.let {
        drawee.setImageURI(it)
    }
}