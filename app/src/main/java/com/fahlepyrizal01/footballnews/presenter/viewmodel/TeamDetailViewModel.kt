package com.fahlepyrizal01.footballnews.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.Team
import com.fahlepyrizal01.core.domain.usecase.FootballUseCase
import kotlinx.coroutines.flow.collect

class TeamDetailViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {

    private var _team = MutableLiveData<Resource<Team>>()
    val team: LiveData<Resource<Team>> = _team

    suspend fun getTeamDetail(idTeam: String) {
        footballUseCase.getTeamDetail(idTeam).collect {
            _team.postValue(it)
        }
    }

    suspend fun updateIsFavorite(team: Team, isFavorite: Boolean) {
        footballUseCase.updateIsFavorite(team, isFavorite)
    }

}