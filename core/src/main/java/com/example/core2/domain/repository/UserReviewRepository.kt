package com.example.core2.domain.repository

import com.example.core2.utils.Resource
import com.example.core2.domain.models.UserReview
import kotlinx.coroutines.flow.Flow

interface UserReviewRepository {
    fun getAllUserReviews() : Flow<Resource<List<UserReview>>>

    fun addUserReview(rating : Double, review : String) : Flow<Resource<Boolean>>
}