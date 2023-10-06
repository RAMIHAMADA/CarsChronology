package com.rami.taxi.ui.main_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rami.taxi.R
import com.rami.taxi.databinding.FragmentCarListBinding

class CarListFragment : Fragment(R.layout.fragment_car_list) {
    private val binding: FragmentCarListBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
