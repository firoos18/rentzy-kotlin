package com.example.rentzy_kotlin.di

import com.example.core2.domain.usecases.UnitInteractor
import com.example.core2.domain.usecases.UnitUseCase
import com.example.rentzy_kotlin.unitList.UnitListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<UnitUseCase> { UnitInteractor(get()) }
}

val unitListViewModelModule = module {
    viewModel { UnitListViewModel(get()) }
}