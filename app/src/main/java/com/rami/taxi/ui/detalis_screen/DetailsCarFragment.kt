package com.rami.taxi.ui.detalis_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rami.taxi.R
import com.rami.taxi.databinding.FragmentDetailsCarBinding

class DetailsCarFragment : Fragment(R.layout.fragment_details_car) {
    private val binding: FragmentDetailsCarBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
