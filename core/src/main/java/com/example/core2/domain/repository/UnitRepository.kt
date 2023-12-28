package com.example.core2.domain.repository

import com.example.core2.utils.Resource
import com.example.core2.domain.models.Unit
import kotlinx.coroutines.flow.Flow

interface UnitRepository {
    fun getAllUnits() : Flow<Resource<List<Unit>>>

    fun getUnitById(unitId : String) : Flow<Resource<Unit>>
}