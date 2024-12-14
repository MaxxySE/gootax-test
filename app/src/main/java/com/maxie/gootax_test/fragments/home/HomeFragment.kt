package com.maxie.gootax_test.fragments.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxie.gootax_test.R
import com.maxie.gootax_test.additional.Debouncer
import com.maxie.gootax_test.databinding.FragmentHomeBinding
import com.maxie.gootax_test.fragments.home.decorators.FirstAndLastItemDecoration
import com.maxie.gootax_test.fragments.home.entities.BannerViewData
import com.maxie.gootax_test.fragments.home.entities.CatalogViewData
import com.maxie.gootax_test.fragments.home.entities.PromoViewData
import com.maxie.gootax_test.fragments.home.entities.RecommendedViewData
import com.maxie.gootax_test.fragments.home.modal.search.SearchFragment
import com.maxie.gootax_test.fragments.home.recyclers.banners.BannersAdapter
import com.maxie.gootax_test.fragments.home.recyclers.catalog.CatalogAdapter
import com.maxie.gootax_test.fragments.home.recyclers.promo.PromoAdapter
import com.maxie.gootax_test.fragments.home.recyclers.recommended.RecommendedAdapter
import com.maxie.gootax_test.fragments.home.viewmodel.HomeViewModel
import com.maxie.gootax_test.viewmodel.SharedViewModelFactory
import com.maxie.gootax_test.viewmodel.SharedViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private var marginStart: Int = 0

    private val homeViewModel: HomeViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels {
        SharedViewModelFactory(requireContext().getSharedPreferences("app_preferences", Context.MODE_PRIVATE))
    }

    private lateinit var recommendedList: List<RecommendedViewData>
    private lateinit var bannersList: List<BannerViewData>
    private lateinit var promoList: List<PromoViewData>
    private lateinit var catalogList: List<CatalogViewData>
    private lateinit var debouncer: Debouncer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        marginStart = resources.getDimensionPixelSize(R.dimen.margin_start_end)
        debouncer = Debouncer(lifecycleScope)

        getServerData()
        setRecyclers()
        setObservers()

        clickListeners()

    }

    private fun getServerData(){
        homeViewModel.getRecommendedData()
        homeViewModel.getBannersData()
        homeViewModel.getPromoData()
        homeViewModel.getCatalogData()
    }

    private fun setRecyclers(){

        homeViewModel.promoList.observe(viewLifecycleOwner) { list ->
            promoList = list
            setPromoRecycler()
        }

        homeViewModel.catalogList.observe(viewLifecycleOwner) { list ->
            catalogList = list
            setCatalogRecycler()
        }

        homeViewModel.bannerList.observe(viewLifecycleOwner) { list ->
            bannersList = list
            setBannersRecycler()
        }

        homeViewModel.recommendedList.observe(viewLifecycleOwner) { list ->
            recommendedList = list
            setRecommendedRecycler()
        }

    }

    private fun setRecommendedRecycler(){

        binding.recommendedRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recommendedRecycler.addItemDecoration(FirstAndLastItemDecoration(marginStart))

        val adapter = RecommendedAdapter(recommendedList) { item ->
            Toast.makeText(requireContext(), item.title, Toast.LENGTH_SHORT).show()
            println(item)
        }

        binding.recommendedRecycler.adapter = adapter

        binding.recommendedRecycler.setHasFixedSize(false)

    }

    private fun setBannersRecycler(){


        binding.bannersRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.bannersRecycler.addItemDecoration(FirstAndLastItemDecoration(marginStart))

        val adapter = BannersAdapter(bannersList) { item ->
            Toast.makeText(requireContext(), item.title, Toast.LENGTH_SHORT).show()
            println(item)
        }

        binding.bannersRecycler.adapter = adapter

    }

    private fun setPromoRecycler(){


        binding.promoRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.promoRecycler.addItemDecoration(FirstAndLastItemDecoration(marginStart))

        val adapter = PromoAdapter(promoList) { item ->
            Toast.makeText(requireContext(), item.promoTitle, Toast.LENGTH_SHORT).show()
            println(item)
        }

        binding.promoRecycler.adapter = adapter


    }

    private fun setCatalogRecycler() {


        binding.catalogRecycler.layoutManager = GridLayoutManager(requireContext(), 3)

        val adapter = CatalogAdapter(catalogList) { item ->
            Toast.makeText(requireContext(), item.title, Toast.LENGTH_SHORT).show()
            println(item)
        }

        binding.catalogRecycler.adapter = adapter

    }

    private fun clickListeners(){
        binding.addressSelector.setOnClickListener {
            debouncer.debounce(200) {
                val bottomSheetFragment = SearchFragment()
                bottomSheetFragment.show(parentFragmentManager, "SearchFragment")
            }
        }

        binding.navButton.setOnClickListener {
            val drawerLayout = requireActivity().findViewById<DrawerLayout>(R.id.drawer_layout)
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
    }

    private fun setObservers() {
        sharedViewModel.address.observe(viewLifecycleOwner) { address ->
            binding.addressTextview.text =
                if (address.isNullOrEmpty()) resources.getText(R.string.order_address_ph)
                else address
        }
    }

}

