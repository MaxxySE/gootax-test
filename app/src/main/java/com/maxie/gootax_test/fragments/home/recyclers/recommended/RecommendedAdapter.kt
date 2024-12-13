package com.maxie.gootax_test.fragments.home.recyclers.recommended

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxie.gootax_test.R
import com.maxie.gootax_test.fragments.home.entities.RecommendedViewData

class RecommendedAdapter(
    private val recommendedList: List<RecommendedViewData>,
    private val onItemClick: (RecommendedViewData) -> Unit )
    : RecyclerView.Adapter<RecommendedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommendation_viewholder, parent, false)
        return RecommendedViewHolder(view)
    }

    override fun getItemCount(): Int = recommendedList.size

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        holder.bind(recommendedList[position], onItemClick)
    }

}