package com.maxie.gootax_test.fragments.home.recyclers.recommended

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maxie.gootax_test.R
import com.maxie.gootax_test.databinding.RecommendationViewholderBinding
import com.maxie.gootax_test.fragments.home.entities.RecommendedViewData

class RecommendedViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: RecommendationViewholderBinding = RecommendationViewholderBinding.bind(itemView)

    fun bind(model: RecommendedViewData, onItemClick: (RecommendedViewData) -> Unit){

        binding.recTitle.text = model.title

        Glide.with(itemView)
            .load(model.imgUri)
            .placeholder(R.drawable.rec_ph)
            .fitCenter()
            .into(binding.recImage)

        itemView.setOnClickListener { onItemClick(model) }

    }

}