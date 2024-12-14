package com.maxie.gootax_test.fragments.home.recyclers.promo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxie.gootax_test.R
import com.maxie.gootax_test.fragments.home.entities.PromoViewData

class PromoAdapter(
    private val promoList: List<PromoViewData>,
    private val onItemClick: (PromoViewData) -> Unit, )
    : RecyclerView.Adapter<PromoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.promotion_viewholder, parent, false)
        return PromoViewHolder(view)
    }

    override fun getItemCount(): Int = promoList.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(promoList[position], onItemClick)

    }

}