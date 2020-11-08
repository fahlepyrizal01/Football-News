package com.fahlepyrizal01.footballnews.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.LeagueDetail
import com.fahlepyrizal01.core.domain.usecase.FootballUseCase
import kotlinx.coroutines.flow.collect

class LeagueDetailViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {

    private var _league = MutableLiveData<Resource<LeagueDetail>>()
    val league: LiveData<Resource<LeagueDetail>> = _league

    suspend fun getLeagueDetail(idLeague: String) {
        footballUseCase.getLeagueDetail(idLeague).collect {
            _league.postValue(it)
        }
    }
}