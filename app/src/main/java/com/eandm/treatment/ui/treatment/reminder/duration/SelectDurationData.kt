package com.eandm.treatment.ui.treatment.reminder.duration

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class SelectDurationData(
    val startDate : Date,
    val durationType: DurationType
) : Parcelable