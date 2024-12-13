package com.maxie.gootax_test.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxie.gootax_test.R
import com.maxie.gootax_test.data.repositories.BannerRepository
import com.maxie.gootax_test.data.repositories.CatalogRepository
import com.maxie.gootax_test.data.repositories.PromoRepository
import com.maxie.gootax_test.data.repositories.RecommendedRepository
import com.maxie.gootax_test.databinding.FragmentHomeBinding
import com.maxie.gootax_test.fragments.home.decorators.FirstAndLastItemDecoration
import com.maxie.gootax_test.fragments.home.recyclers.banners.BannersAdapter
import com.maxie.gootax_test.fragments.home.recyclers.catalog.CatalogAdapter
import com.maxie.gootax_test.fragments.home.recyclers.promo.PromoAdapter
import com.maxie.gootax_test.fragments.home.recyclers.recommended.RecommendedAdapter
import com.maxie.gootax_test.fragments.home.viewmodel.HomeViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private var marginStart: Int = 0
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        marginStart = resources.getDimensionPixelSize(R.dimen.margin_start_end)

        setRecommendedRecycler()
        setBannersRecycler()
        setPromoRecycler()
        setCatalogRecycler()

    }

    private fun setRecommendedRecycler(){

        val recommendedList = RecommendedRepository().fetchRecommendedData()
        binding.recommendedRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recommendedRecycler.addItemDecoration(FirstAndLastItemDecoration(marginStart))

        val adapter = RecommendedAdapter(recommendedList) { item ->
            Toast.makeText(requireContext(), item.title, Toast.LENGTH_SHORT).show()
            println(item)
        }

        binding.recommendedRecycler.adapter = adapter

    }

    private fun setBannersRecycler(){

        val bannersList = BannerRepository().fetchBannerData()

        binding.bannersRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.bannersRecycler.addItemDecoration(FirstAndLastItemDecoration(marginStart))

        val adapter = BannersAdapter(bannersList) { item ->
            Toast.makeText(requireContext(), item.title, Toast.LENGTH_SHORT).show()
            println(item)
        }

        binding.bannersRecycler.adapter = adapter

    }

    private fun setPromoRecycler(){

        val promoList = PromoRepository().fetchPromoData()

        binding.promoRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.promoRecycler.addItemDecoration(FirstAndLastItemDecoration(marginStart))

        val adapter = PromoAdapter(promoList) { item ->
            Toast.makeText(requireContext(), item.promoTitle, Toast.LENGTH_SHORT).show()
            println(item)
        }

        binding.promoRecycler.adapter = adapter


    }

    private fun setCatalogRecycler() {

        val catalogList = CatalogRepository().fetchCatalogData()

        binding.catalogRecycler.layoutManager = GridLayoutManager(requireContext(), 3)

        val adapter = CatalogAdapter(catalogList) { item ->
            Toast.makeText(requireContext(), item.title, Toast.LENGTH_SHORT).show()
            println(item)
        }

        binding.catalogRecycler.adapter = adapter

    }

}

