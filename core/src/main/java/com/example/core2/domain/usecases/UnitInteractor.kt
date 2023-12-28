package com.example.core2.domain.usecases

import com.example.core2.domain.models.Unit
import com.example.core2.domain.repository.UnitRepository
import com.example.core2.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class UnitInteractor(
    private val unitRepository: UnitRepository
) : UnitUseCase {
    override fun getAllUnits(): Flow<Resource<List<Unit>>> = unitRepository.getAllUnits()

    override fun getUnitById(id: String): Flow<Resource<Unit>> = unitRepository.getUnitById(unitId = id)
}