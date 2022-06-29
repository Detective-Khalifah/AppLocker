package com.momentolabs.app.security.applocker.repository

import com.momentolabs.app.security.applocker.data.AppLockerPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferencesRepository @Inject constructor(val appLockerPreferences: AppLockerPreferences) {

    fun endSession(){}
}