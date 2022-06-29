package com.momentolabs.app.security.applocker.ui.permissions

import android.content.Intent
import android.net.Uri
import android.provider.Settings


object IntentHelper {

    fun overlayIntent(packageName: String): Intent {
        return Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
    }

    fun usageAccessIntent(): Intent {
        return Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
    }
}