package com.muryno.muzic.component.diagnostics

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.lifecycle.LifecycleOwner
import com.kylecorry.andromeda.sense.Sensors
import com.kylecorry.andromeda.sense.light.ILightSensor
import com.kylecorry.andromeda.sense.light.LightSensor

class LightSensorDiagnostic(context: Context, lifecycleOwner: LifecycleOwner?) :
    BaseSensorQualityDiagnostic<ILightSensor>(
        context,
        lifecycleOwner,
        LightSensor(context, SensorManager.SENSOR_DELAY_NORMAL)
    ) {

    override fun scan(): List<DiagnosticCode> {
        if (!Sensors.hasSensor(context, Sensor.TYPE_LIGHT)) {
            return listOf(DiagnosticCode.LightSensorUnavailable)
        }

        return emptyList()
    }

}