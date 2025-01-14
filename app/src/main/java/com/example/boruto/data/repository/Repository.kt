package com.example.boruto.data.repository

import com.example.boruto.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStoreOperations
) {

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(complete = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}