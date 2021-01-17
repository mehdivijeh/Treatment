package com.eandm.treatment.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TreatmentType(
    val id: Int,
    @StringRes val itemTitleResource: Int,
    @DrawableRes val itemIconResource: Int
)