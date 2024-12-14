package com.maxie.gootax_test.fragments.home.modal.search.recyclers.addresses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxie.gootax_test.R
import com.maxie.gootax_test.fragments.home.entities.SearchViewData


class SearchAdapter(
    private val searchList: List<SearchViewData>,
    private val onItemClick: (SearchViewData) -> Unit
): RecyclerView.Adapter<SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_viewholder, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int = searchList.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchList[position], onItemClick)
    }

}