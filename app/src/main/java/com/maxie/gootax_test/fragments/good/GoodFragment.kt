package com.maxie.gootax_test.fragments.good

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxie.gootax_test.R
import com.maxie.gootax_test.databinding.FragmentGoodBinding

class GoodFragment : Fragment(R.layout.fragment_good) {

    private lateinit var binding: FragmentGoodBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGoodBinding.bind(view)
    }

}