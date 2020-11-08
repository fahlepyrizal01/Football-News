package com.fahlepyrizal01.footballnews.di

import com.fahlepyrizal01.core.domain.usecase.FootballInteractor
import com.fahlepyrizal01.core.domain.usecase.FootballUseCase
import com.fahlepyrizal01.footballnews.presenter.viewmodel.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<FootballUseCase> { FootballInteractor(get()) }
}

val viewModelModule = module {
    viewModel { LeaguesViewModel(get()) }
    viewModel { LeagueDetailViewModel(get()) }
    viewModel { StandingsViewModel(get()) }
    viewModel { TeamsViewModel(get()) }
    viewModel { TeamDetailViewModel(get()) }
    viewModel { EventsViewModel(get()) }
    viewModel { SearchTeamsViewModel(get()) }
}