package com.maxie.gootax_test.fragments.home.recyclers.banners

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maxie.gootax_test.R
import com.maxie.gootax_test.databinding.BannerViewholderBinding
import com.maxie.gootax_test.fragments.home.entities.BannerViewData

class BannersViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: BannerViewholderBinding = BannerViewholderBinding.bind(itemView)

    fun bind(model: BannerViewData, onItemClick: (BannerViewData) -> Unit){

        Glide.with(itemView)
            .load(model.imgUri)
            .placeholder(R.drawable.banner_ph)
            .fitCenter()
            .into(binding.bannerImage)

        itemView.setOnClickListener { onItemClick(model) }

    }

}