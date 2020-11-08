package com.fahlepyrizal01.favorite.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahlepyrizal01.core.domain.model.Team
import com.fahlepyrizal01.core.domain.usecase.FootballUseCase
import kotlinx.coroutines.flow.collect

class FavoriteTeamsViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {

    private var _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = _teams

    suspend fun getFavoriteList() {
        footballUseCase.getFavoriteTeamList().collect {
            _teams.postValue(it)
        }
    }
}