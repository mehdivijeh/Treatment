package com.eandm.treatment.ui.treatment.reminder

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddReminderData (
    val name : String,
    val unit : String,
    val reminderType: ReminderType
) : Parcelable