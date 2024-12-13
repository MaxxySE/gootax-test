package com.maxie.gootax_test.fragments.home.recyclers.catalog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxie.gootax_test.R
import com.maxie.gootax_test.fragments.home.entities.CatalogViewData


class CatalogAdapter(
    private val catalogList: List<CatalogViewData>,
    private val onItemClick: (CatalogViewData) -> Unit )
    : RecyclerView.Adapter<CatalogViewHolder>() {

    private var maxHeight = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.catalog_viewholder, parent, false)
        return CatalogViewHolder(view)
    }

    override fun getItemCount(): Int = catalogList.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(catalogList[position], onItemClick)

        holder.itemView.post {
            val itemHeight = holder.itemView.height
            if (itemHeight > maxHeight) {
                maxHeight = itemHeight
                notifyDataSetChanged()
            } else if (itemHeight < maxHeight) {
                holder.itemView.layoutParams.height = maxHeight
                holder.itemView.requestLayout()
            }
        }
    }

}
