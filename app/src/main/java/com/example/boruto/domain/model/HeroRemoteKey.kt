package com.example.boruto.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.boruto.util.Constant.HERO_REMOTE_KEY_DATABASE_TABLE

@Entity(tableName = HERO_REMOTE_KEY_DATABASE_TABLE)
data class HeroRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevKey: Int?,
    val nextKey: Int?
)
