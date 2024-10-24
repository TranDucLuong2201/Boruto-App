package com.example.boruto.data.pref

import com.example.boruto.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow

class DataStoreOperationsImpl:DataStoreOperations {
    override suspend fun saveOnBoardingState(complete: Boolean) {

    }

    override fun readOnBoardingState(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}