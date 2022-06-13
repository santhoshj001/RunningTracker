package com.teamb.runningtracker.common

import androidx.datastore.preferences.core.booleanPreferencesKey

object Constants {
    const val TABLE_NAME = "run"
    const val PROTO_DATA_STORE = "proto_data_store"

    const val USER_PREFERENCE = "user_preference"
    val IS_ON_BOARDING_COMPLETED = booleanPreferencesKey("on_boarding_completed")
}