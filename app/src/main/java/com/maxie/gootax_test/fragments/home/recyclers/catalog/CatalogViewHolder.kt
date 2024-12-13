package com.maxie.gootax_test.fragments.home.recyclers.catalog

import android.content.res.ColorStateList
import android.view.View
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maxie.gootax_test.R
import com.maxie.gootax_test.databinding.CatalogViewholderBinding
import com.maxie.gootax_test.fragments.home.entities.CatalogViewData


class CatalogViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: CatalogViewholderBinding = CatalogViewholderBinding.bind(itemView)

    fun bind(model: CatalogViewData, onItemClick: (CatalogViewData) -> Unit){

        binding.catViewTitle.text = model.title

        binding.catView.backgroundTintList = ColorStateList.valueOf(model.backgroundColor.toColorInt())

        Glide.with(itemView)
            .load(model.imgUri)
            .placeholder(R.drawable.cat_ph)
            .fitCenter()
            .into(binding.catViewImage)

        itemView.setOnClickListener { onItemClick(model) }

    }

}