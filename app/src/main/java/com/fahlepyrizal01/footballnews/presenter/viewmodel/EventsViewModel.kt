package com.fahlepyrizal01.footballnews.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.Event
import com.fahlepyrizal01.core.domain.usecase.FootballUseCase
import kotlinx.coroutines.flow.collect

class EventsViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {


    private var _lastEvents = MutableLiveData<Resource<List<Event>>>()
    val lastEvents: LiveData<Resource<List<Event>>> = _lastEvents

    private var _nextEvents = MutableLiveData<Resource<List<Event>>>()
    val nextEvents: LiveData<Resource<List<Event>>> = _nextEvents

    suspend fun getLastEventList(idTeam: String) {
        footballUseCase.getEventList(idTeam, true).collect {
            _lastEvents.postValue(it)
        }
    }

    suspend fun getNextEventList(idTeam: String) {
        footballUseCase.getEventList(idTeam, false).collect {
            _nextEvents.postValue(it)
        }
    }
}