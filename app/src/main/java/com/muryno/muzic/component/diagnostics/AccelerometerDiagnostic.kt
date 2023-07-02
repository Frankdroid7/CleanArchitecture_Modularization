package com.muryno.muzic.component.diagnostics

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.lifecycle.LifecycleOwner
import com.kylecorry.andromeda.core.sensors.Quality
import com.kylecorry.andromeda.sense.Sensors
import com.kylecorry.andromeda.sense.accelerometer.Accelerometer
import com.kylecorry.andromeda.sense.accelerometer.IAccelerometer
import com.kylecorry.trail_sense.diagnostics.BaseSensorQualityDiagnostic
import com.kylecorry.trail_sense.diagnostics.DiagnosticCode

class AccelerometerDiagnostic(context: Context, lifecycleOwner: LifecycleOwner?) :
    BaseSensorQualityDiagnostic<IAccelerometer>(
        context,
        lifecycleOwner,
        Accelerometer(context, SensorManager.SENSOR_DELAY_NORMAL)
    ) {

    override fun scan(): List<DiagnosticCode> {
        if (!Sensors.hasSensor(context, Sensor.TYPE_ACCELEROMETER)) {
            return listOf(DiagnosticCode.AccelerometerUnavailable)
        }

        if (canRun && sensor!!.quality == Quality.Poor) {
            return listOf(DiagnosticCode.AccelerometerPoor)
        }

        return emptyList()
    }

}