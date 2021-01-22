package com.eandm.treatment.ui.treatment.reminder.duration

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

sealed class DurationType : Parcelable{

    @Parcelize
    object NoEndDate : DurationType()

    @Parcelize
    data class UntilDate(
        val until : Date
    ) : DurationType()

    @Parcelize
    data class ForXDays(
        val duration : Int
    ) : DurationType()
}