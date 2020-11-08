package com.fahlepyrizal01.favorite.di

import com.fahlepyrizal01.favorite.presenter.viewmodel.FavoriteTeamsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteTeamsViewModel(get()) }
}