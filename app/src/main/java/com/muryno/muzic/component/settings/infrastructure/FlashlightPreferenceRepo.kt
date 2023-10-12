package com.muryno.muzic.component.settings.infrastructure

import android.content.Context
import com.kylecorry.andromeda.preferences.BooleanPreference
import com.kylecorry.andromeda.preferences.FloatPreference
import com.kylecorry.trail_sense.R
import java.time.Duration

class FlashlightPreferenceRepo(context: Context) : PreferenceRepo(context) {

    var toggleWithVolumeButtons by BooleanPreference(
        cache,
        getString(R.string.pref_flashlight_toggle_with_volume),
        false
    )

    val shouldTimeout by BooleanPreference(
        cache,
        context.getString(R.string.pref_flashlight_should_timeout),
        false
    )

    var brightness by FloatPreference(
        cache,
        context.getString(R.string.pref_torch_brightness),
        1f
    )

    var timeout: Duration
        get() {
            val seconds =
                cache.getLong(context.getString(R.string.pref_flashlight_timeout)) ?: (5L * 60)
            return Duration.ofSeconds(seconds)
        }
        set(value) {
            cache.putLong(context.getString(R.string.pref_flashlight_timeout), value.seconds)
        }

}