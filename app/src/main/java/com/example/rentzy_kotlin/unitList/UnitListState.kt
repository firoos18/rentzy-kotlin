package com.example.rentzy_kotlin.unitList

import com.example.core2.domain.models.Unit

data class UnitListState (
    val isLoading : Boolean = false,
    val units : List<com.example.core2.domain.models.Unit> = emptyList(),
    val error : String = ""
)