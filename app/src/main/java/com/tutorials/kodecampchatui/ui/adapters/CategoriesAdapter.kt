package com.tutorials.kodecampchatui.ui.adapters

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tutorials.kodecampchatui.data.model.Category
import com.tutorials.kodecampchatui.R
import com.tutorials.kodecampchatui.databinding.CategoriesViewholderBinding

class CategoriesAdapter()  : ListAdapter<Category, CategoriesAdapter.ViewHolder>(diffObject) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CategoriesViewholderBinding.bind(view)
        private val selectedTypedValue = TypedValue()
        private val theme = itemView.context.theme
        fun bind(category: Category) {
            binding.apply {
                categoryText.text = category.name
                if (category.isSelected) {
                    theme.resolveAttribute(
                        com.google.android.material.R.attr.colorOnSurface,
                        selectedTypedValue,
                        true
                    )
                    val color = selectedTypedValue.data
                    val underLineParams = underLine.layoutParams
                    underLineParams.height = 8
                    underLine.setBackgroundColor(color)

                } else {
                    val underLineParams = underLine.layoutParams
                    underLineParams.height = 2
                    underLine.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.search_background_color))

                }
                root.setOnClickListener {
                    listener?.let {
                        it(category)
                    }
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.categories_viewholder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = getItem(position)
        if (pos != null)
            holder.bind(pos)

    }

    companion object {
        val diffObject = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.id == newItem.id && oldItem.isSelected == newItem.isSelected
            }
        }
    }

    private var listener: ((Category) -> Unit)? = null

    fun adapterClickListener(listener: (Category) -> Unit) {
        this.listener = listener
    }

    /*
    * if (category.isSelected) {
                    theme.resolveAttribute(
                        com.google.android.material.R.attr.colorSurface,
                        selectedTypedValue,
                        true
                    )
                    val color = selectedTypedValue.data
                    categoryText.setTextColor(color)
                    underLine.setBackgroundColor(color)
                } else {
                    theme.resolveAttribute(
                        com.google.android.material.R.attr.colorOnSurface,
                        unSelectedTypedValue,
                        true
                    )
                    val color = unSelectedTypedValue.data
                    categoryText.setTextColor(color)
                    underLine.setBackgroundColor(color)
                }*/

}