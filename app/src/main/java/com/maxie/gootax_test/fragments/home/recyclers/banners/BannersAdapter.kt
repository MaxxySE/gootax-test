package com.maxie.gootax_test.fragments.home.recyclers.banners

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxie.gootax_test.R
import com.maxie.gootax_test.fragments.home.entities.BannerViewData

class BannersAdapter(
    private val bannersList: List<BannerViewData>,
    private val onItemClick: (BannerViewData) -> Unit )
    : RecyclerView.Adapter<BannersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_viewholder, parent, false)
        return BannersViewHolder(view)
    }

    override fun getItemCount(): Int = bannersList.size

    override fun onBindViewHolder(holder: BannersViewHolder, position: Int) {
        holder.bind(bannersList[position], onItemClick)
    }

}