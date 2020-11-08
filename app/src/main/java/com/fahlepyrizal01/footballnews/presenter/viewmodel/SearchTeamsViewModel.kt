package com.fahlepyrizal01.footballnews.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.Team
import com.fahlepyrizal01.core.domain.usecase.FootballUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

class SearchTeamsViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {

    private var _teams = MutableLiveData<Resource<List<Team>>>()
    val teams: LiveData<Resource<List<Team>>> = _teams

    @ExperimentalCoroutinesApi
    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    @ExperimentalCoroutinesApi
    @FlowPreview
    val search = queryChannel.asFlow()
        .debounce(300)
        .distinctUntilChanged()
        .filter { it.trim().isNotEmpty() }
        .mapLatest { it }
        .asLiveData()

    suspend fun searchTeams(keyWord: String) {
        footballUseCase.searchTeams(keyWord).collect {
            _teams.postValue(it)
        }
    }

}