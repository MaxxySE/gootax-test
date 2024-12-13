package com.maxie.gootax_test.fragments.home.recyclers.promo

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.View
import androidx.core.graphics.toColorInt
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maxie.gootax_test.R
import com.maxie.gootax_test.databinding.PromotionViewholderBinding
import com.maxie.gootax_test.fragments.home.entities.PromoViewData
import com.maxie.gootax_test.fragments.home.viewmodel.HomeViewModel

class PromoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: PromotionViewholderBinding = PromotionViewholderBinding.bind(itemView)
    private val viewModel = HomeViewModel()

    @SuppressLint("SetTextI18n")
    fun bind(model: PromoViewData,
             onItemClick: (PromoViewData) -> Unit,
    ){

        binding.promoViewPrice.text = "${model.price} ₽"
        binding.promoViewTitle.text = model.promoTitle
        binding.promoViewPercent.text = "-${model.promoPercentage}%"
        binding.promoViewWeight.text = "${model.weight} г"
        binding.promoViewDiscountPrice.text = "${model.promoPrice} ₽"
        binding.promoViewHiddenprice.text = "${model.price} ₽"

        if (model.promoStatus) {
            binding.promoViewStatus.visibility = View.VISIBLE
        } else {
            binding.promoViewStatus.visibility = View.INVISIBLE
        }

        binding.promoView.backgroundTintList = ColorStateList.valueOf(model.backgroundColor.toColorInt())

        Glide.with(itemView)
            .load(model.imgUri)
            .placeholder(R.drawable.promo_ph)
            .fitCenter()
            .into(binding.promoViewImage)

        itemView.setOnClickListener { onItemClick(model) }

        viewModel.goodsAmount.observeForever { amount ->
            binding.promoViewAmount.text = amount.toString()
            if (amount > 0) {
                binding.promoViewUnselected.visibility = View.GONE
                binding.promoViewSelected.visibility = View.VISIBLE
                binding.promoViewHiddenprice.visibility = View.VISIBLE
            } else {
                binding.promoViewSelected.visibility = View.GONE
                binding.promoViewUnselected.visibility = View.VISIBLE
                binding.promoViewHiddenprice.visibility = View.INVISIBLE
            }
        }

        binding.promoViewAdd.setOnClickListener {
            viewModel.addGoodsAmount()
        }

        binding.promoViewAddmore.setOnClickListener {
            viewModel.addGoodsAmount()
        }

        binding.promoViewRemove.setOnClickListener {
            viewModel.removeGoodsAmount()
        }

    }

}