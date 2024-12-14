package com.maxie.gootax_test.fragments.home.modal.search

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.maxie.gootax_test.R
import com.maxie.gootax_test.additional.Debouncer
import com.maxie.gootax_test.api.ApiService
import com.maxie.gootax_test.api.RetrofitInstance
import com.maxie.gootax_test.data.constants.SearchConstants
import com.maxie.gootax_test.databinding.FragmentSearchBinding
import com.maxie.gootax_test.fragments.home.entities.SearchViewData
import com.maxie.gootax_test.fragments.home.modal.search.recyclers.addresses.SearchAdapter
import com.maxie.gootax_test.fragments.home.modal.search.viewmodel.SearchViewModel
import com.maxie.gootax_test.viewmodel.SharedViewModelFactory
import com.maxie.gootax_test.viewmodel.SharedViewModel


class SearchFragment : BottomSheetDialogFragment(R.layout.fragment_search) {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var debouncer: Debouncer

    private val sharedViewModel: SharedViewModel by activityViewModels {
        SharedViewModelFactory(requireContext().getSharedPreferences("app_preferences", Context.MODE_PRIVATE))
    }

    private val searchViewModel: SearchViewModel by viewModels()

    private val apiService: ApiService =
        RetrofitInstance.getRetrofit(SearchConstants.getApiUrl()).create(ApiService::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        debouncer = Debouncer(lifecycleScope)

        setObservers()

        clickListeners()
        fieldListeners()

    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog as? BottomSheetDialog ?: return
        val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) ?: return
        val behavior = BottomSheetBehavior.from(bottomSheet)

        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        bottomSheet.layoutParams.height = (resources.displayMetrics.heightPixels - dpToPx(48))
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }

    private fun setObservers(){
        searchViewModel.searchResults.observe(viewLifecycleOwner) { searchResults ->
            println(searchResults)
            setSearchRecycler(searchResults)
        }
    }

    private fun clickListeners() {
        binding.currentLocationButton.setOnClickListener {
            searchViewModel.getSuggestedResponse(apiService, "болгарская 47")
        }

        binding.clearSearchButton.setOnClickListener {
            binding.searchEdittext.text.clear()
        }
    }

    private fun fieldListeners() {
        binding.searchEdittext.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (binding.searchEdittext.text.isNotEmpty()) {
                    debouncer.debounce(300) {
                        searchViewModel.getSuggestedResponse(apiService, p0.toString())
                    }
                    binding.clearSearchButton.visibility = View.VISIBLE
                } else {
                    binding.clearSearchButton.visibility = View.GONE
                }
            }

            override fun afterTextChanged(p0: Editable?) {}

        })
    }

    private fun setSearchRecycler(searchList: List<SearchViewData>) {
        val adapter = SearchAdapter(searchList.toMutableList()) { item ->
            Toast.makeText(requireContext(), item.city, Toast.LENGTH_SHORT).show()
            println(item)
            val address = "${item.street}, ${item.house}"
            sharedViewModel.setAddress(address)
            dismiss()
        }

        binding.searchRecycle.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecycle.adapter = adapter
    }

}