package com.teamb.runningtracker.di

import android.content.Context
import androidx.room.Room
import com.teamb.runningtracker.data.local.RunDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRunDataBase(@ApplicationContext context: Context): RunDatabase {
        return Room.databaseBuilder(
            context,
            RunDatabase::class.java,
            "run_database"
        ).build()
    }

}