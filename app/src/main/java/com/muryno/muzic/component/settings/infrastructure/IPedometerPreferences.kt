package com.muryno.muzic.component.settings.infrastructure

import com.kylecorry.sol.units.Distance

interface IPedometerPreferences {
    var isEnabled: Boolean
    val resetDaily: Boolean
    var strideLength: Distance
    var alertDistance: Distance?
}