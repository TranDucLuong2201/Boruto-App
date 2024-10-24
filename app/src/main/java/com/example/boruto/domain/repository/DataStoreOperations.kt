package com.example.boruto.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveOnBoardingState(complete: Boolean)
    fun readOnBoardingState() : Flow<Boolean>
}