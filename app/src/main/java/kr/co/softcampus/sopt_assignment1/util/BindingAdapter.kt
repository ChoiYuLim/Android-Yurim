package kr.co.softcampus.sopt_assignment1.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("imgRes")
    fun setImage(imageView: ImageView, resid: Int) {
        imageView.setImageResource(resid)
    }
}