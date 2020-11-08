package com.fahlepyrizal01.footballnews.presenter.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.fahlepyrizal01.footballnews.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(THIRD_SECOND)
            super.getView()?.findNavController()?.navigate(
                SplashFragmentDirections.actionSplashFragmentToLeaguesFragment()
            )
        }

    }

    companion object {
        const val THIRD_SECOND = 3000L
    }

}