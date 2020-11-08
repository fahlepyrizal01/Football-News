package com.fahlepyrizal01.footballnews.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.Team
import com.fahlepyrizal01.core.domain.usecase.FootballUseCase
import kotlinx.coroutines.flow.collect

class TeamsViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {

    private var _teams = MutableLiveData<Resource<List<Team>>>()
    val teams: LiveData<Resource<List<Team>>> = _teams

    suspend fun getTeamList(idLeague: String) {
        footballUseCase.getTeamList(idLeague).collect {
            _teams.postValue(it)
        }
    }
}