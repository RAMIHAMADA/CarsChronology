package com.rami.taxi.ui.splash

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rami.taxi.R
import com.rami.taxi.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    private val binding: FragmentSplashBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun startAnimations() {
        binding.lottieCar.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animator: Animator) {
            }
        })
    }
}
