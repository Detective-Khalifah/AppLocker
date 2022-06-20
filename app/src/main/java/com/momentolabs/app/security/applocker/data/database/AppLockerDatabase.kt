package com.momentolabs.app.security.applocker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.momentolabs.app.security.applocker.data.database.lockedapps.LockedAppEntity
import com.momentolabs.app.security.applocker.data.database.lockedapps.LockedAppsDao
import com.momentolabs.app.security.applocker.data.database.pattern.PatternDao
import com.momentolabs.app.security.applocker.data.database.pattern.PatternEntity


@Database(
    entities = [LockedAppEntity::class, PatternEntity::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(DateTypeConverters::class)
abstract class AppLockerDatabase : RoomDatabase() {

    abstract fun getLockedAppsDao(): LockedAppsDao

    abstract fun getPatternDao(): PatternDao
}