package com.momentolabs.app.security.applocker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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

    companion object {

        val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `blacklist` (`blacklist_id` INTEGER NOT NULL,`user_name` TEXT NOT NULL,`phone_number` TEXT NOT NULL, PRIMARY KEY(`blacklist_id`))")
                database.execSQL("CREATE TABLE IF NOT EXISTS `call_log` (`log_id` INTEGER NOT NULL,`call_log_time` INTEGER NOT NULL,`user_name` TEXT NOT NULL,`phone_number` TEXT NOT NULL, PRIMARY KEY(`log_id`))")
            }
        }
    }
}