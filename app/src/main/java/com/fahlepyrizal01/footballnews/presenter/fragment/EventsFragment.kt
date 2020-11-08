package com.fahlepyrizal01.footballnews.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.footballnews.R
import com.fahlepyrizal01.footballnews.adapter.EventRecyclerViewAdapter
import com.fahlepyrizal01.footballnews.presenter.viewmodel.EventsViewModel
import kotlinx.android.synthetic.main.fragment_events.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class EventsFragment : Fragment() {

    companion object {
        private const val ARG_IS_LAST_EVENT = "isLastEvent"
        private const val ARG_ID_TEAM = "idTeam"
        fun newInstance(isLastEvent: Boolean, idTeam: String): EventsFragment {
            val fragment = EventsFragment()
            val bundle = Bundle()
            bundle.putBoolean(ARG_IS_LAST_EVENT, isLastEvent)
            bundle.putString(ARG_ID_TEAM, idTeam)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val viewModel: EventsViewModel by viewModel()

    private val recyclerViewAdapter by lazy {
        EventRecyclerViewAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idTeam = arguments?.getString(ARG_ID_TEAM).orEmpty()
        val isLastEvent = arguments?.getBoolean(ARG_IS_LAST_EVENT) ?: false

        setupRecyclerView()

        if (arguments != null) {
            if (isLastEvent) {
                viewModel.lastEvents
            } else {
                viewModel.nextEvents
            }.let { liveData ->
                liveData.observe(viewLifecycleOwner, {
                    when (it) {
                        is Resource.Loading -> {
                            it.getLoadingStateIfNotHandled()?.let {
                                rv_event_event.visibility = View.GONE
                                pb_event.visibility = View.VISIBLE
                            }
                        }
                        is Resource.Success -> {
                            it.getSuccessStateIfNotHandled()?.let { data ->
                                pb_event.visibility = View.GONE
                                lav_empty_or_error_events.visibility = View.GONE
                                recyclerViewAdapter.setData(data)
                                rv_event_event.visibility = View.VISIBLE
                            }
                        }
                        is Resource.Error -> {
                            it.getErrorStateIfNotHandled()?.let {
                                pb_event.visibility = View.GONE
                                lav_empty_or_error_events.visibility = View.VISIBLE
                            }
                        }
                    }
                })
            }

            viewLifecycleOwner.lifecycleScope.launch {
                if (isLastEvent) viewModel.getLastEventList(idTeam)
                else viewModel.getNextEventList(idTeam)
            }
        }

    }

    override fun onDestroyView() {

        rv_event_event.apply {
            addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener{
                override fun onViewAttachedToWindow(v: View?) {}

                override fun onViewDetachedFromWindow(v: View?) {
                    adapter = null
                }

            })
        }

        super.onDestroyView()

    }

    private fun setupRecyclerView() = with(rv_event_event) {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = recyclerViewAdapter
    }
}