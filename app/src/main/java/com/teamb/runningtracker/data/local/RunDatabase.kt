package com.teamb.runningtracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [RunEntity::class],
    version = 1
)
abstract class RunDatabase() : RoomDatabase() {
    abstract val runDao: RunDao
}