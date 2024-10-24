package com.example.boruto.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.boruto.domain.model.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

    @Query("SELECT * FROM hero_remote_key_database WHERE id = :id")
    suspend fun getRemoteKey(id: Int): HeroRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKey(heroRemoteKeys: List<HeroRemoteKey>)

    @Query("DELETE FROM hero_remote_key_database")
    suspend fun deleteAllRemoteKey()
}