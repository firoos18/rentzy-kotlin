package com.example.core2.domain.repository

import com.example.core2.utils.Resource
import com.example.core2.domain.models.Brands
import kotlinx.coroutines.flow.Flow

interface BrandsRepository {
    fun getAllBrands() : Flow<Resource<List<Brands>>>
}