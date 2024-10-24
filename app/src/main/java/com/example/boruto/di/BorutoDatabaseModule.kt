package com.example.boruto.di

import android.content.Context
import androidx.room.Room
import com.example.boruto.data.local.BorutoDatabase
import com.example.boruto.util.Constant.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BorutoDatabaseModule {

    @Provides
    @Singleton
    fun providerDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context = context,
            klass = BorutoDatabase::class.java,
            name = BORUTO_DATABASE
    ).build()

}