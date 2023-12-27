package com.example.rentzy_kotlin.unitList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core2.domain.usecases.UnitUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class UnitListViewModel(
    private val unitUseCase: UnitUseCase
) : ViewModel() {
    private val _state = mutableStateOf(UnitListState())

    val state : State<UnitListState> get() = _state

    init {
        getAllUnits()
    }

    private fun getAllUnits() {
        val unitList = unitUseCase.getAllUnits()
        unitList.onEach { result ->
            when(result) {
                is com.example.core2.utils.Resource.Success -> {
                    _state.value = UnitListState(units = result.data ?: emptyList())
                }
                is com.example.core2.utils.Resource.Error -> {
                    _state.value = UnitListState(error = result.message ?: "An Unexpected Error Occurred")
                }
                is com.example.core2.utils.Resource.Loading -> {
                    _state.value = UnitListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}