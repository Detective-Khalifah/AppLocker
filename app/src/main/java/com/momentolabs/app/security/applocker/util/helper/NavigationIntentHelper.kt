package com.momentolabs.app.security.applocker.util.helper

import android.content.Intent
import android.net.Uri
import com.momentolabs.app.security.applocker.BuildConfig
import androidx.core.content.ContextCompat.startActivity


object NavigationIntentHelper {

    fun getFeedbackIntent(): Intent {
        val emailIntent = Intent(
            Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "momentolabs@gmail.com", null
            )
        )
        return Intent.createChooser(emailIntent, "Send email...")
    }
}