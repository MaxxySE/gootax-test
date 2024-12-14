package com.maxie.gootax_test.fragments.home.modal.search.recyclers.addresses

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.maxie.gootax_test.databinding.SearchViewholderBinding
import com.maxie.gootax_test.fragments.home.entities.SearchViewData

class SearchViewHolder  (itemView: View) : RecyclerView.ViewHolder(itemView)  {

    private val binding: SearchViewholderBinding = SearchViewholderBinding.bind(itemView)

    @SuppressLint("SetTextI18n")
    fun bind(
        model: SearchViewData,
        onItemClick: (SearchViewData) -> Unit
    ) {

        binding.searchTitle.text =
            "${model.street} ${model.street_type}., ${model.house}"
        binding.searchSubtitle.text =
            "${model.city}, ${model.region_type_full} ${model.region}, ${model.country}"

        itemView.setOnClickListener { onItemClick(model) }

    }

}