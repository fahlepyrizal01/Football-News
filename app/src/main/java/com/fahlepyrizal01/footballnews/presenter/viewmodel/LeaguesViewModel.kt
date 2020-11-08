package com.fahlepyrizal01.footballnews.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.League
import com.fahlepyrizal01.core.domain.usecase.FootballUseCase
import kotlinx.coroutines.flow.collect

class LeaguesViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {

    private var _leagues = MutableLiveData<Resource<List<League>>>()
    val leagues: LiveData<Resource<List<League>>> = _leagues

    suspend fun getLeagueList() {
        footballUseCase.getLeagueList().collect {
            _leagues.postValue(it)
        }
    }
}