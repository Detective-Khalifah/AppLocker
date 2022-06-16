package com.momentolabs.app.security.applocker.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    companion object {
        const val DB_NAME = "applocker.db"
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context) = Room
            .databaseBuilder(context, AppLockerDatabase::class.java, DB_NAME)
            .build()

    @Provides
    @Singleton
    fun provideLockedAppsDao(db: AppLockerDatabase) = db.getLockedAppsDao()

    @Provides
    @Singleton
    fun providePatternDao(db: AppLockerDatabase) = db.getPatternDao()

}