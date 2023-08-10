package com.muryno.muzic.component.settings.infrastructure

import android.content.Context
import com.kylecorry.trail_sense.settings.infrastructure.IErrorPreferences
import com.kylecorry.trail_sense.shared.ErrorBannerReason
import com.kylecorry.trail_sense.shared.preferences.PreferencesSubsystem

class ErrorPreferences(context: Context) : IErrorPreferences {

    private val cache = PreferencesSubsystem.getInstance(context).preferences

    override fun canShowError(error: ErrorBannerReason): Boolean {
        return cache.getBoolean("pref_can_show_error_${error.id}") ?: true
    }

    override fun setCanShowError(error: ErrorBannerReason, canShow: Boolean) {
        cache.putBoolean("pref_can_show_error_${error.id}", canShow)
    }
}