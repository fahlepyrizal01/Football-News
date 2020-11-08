package com.fahlepyrizal01.footballnews.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.Standing
import com.fahlepyrizal01.core.domain.usecase.FootballUseCase
import kotlinx.coroutines.flow.collect

class StandingsViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {

    private var _standings = MutableLiveData<Resource<List<Standing>>>()
    val standings: LiveData<Resource<List<Standing>>> = _standings

    suspend fun getStandingList(idLeague: String) {
        footballUseCase.getStandingList(idLeague).collect {
            _standings.postValue(it)
        }
    }
}