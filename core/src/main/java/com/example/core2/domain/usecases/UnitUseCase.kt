package com.example.core2.domain.usecases

import com.example.core2.domain.models.Unit
import com.example.core2.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UnitUseCase {
    fun getAllUnits() : Flow<Resource<List<Unit>>>

    fun getUnitById(id : String) : Flow<Resource<Unit>>
}