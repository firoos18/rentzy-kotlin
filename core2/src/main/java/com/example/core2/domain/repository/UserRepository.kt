package com.example.core2.domain.repository

import com.example.core2.utils.Resource
import com.example.core2.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserInformation() : Flow<Resource<User>>
}