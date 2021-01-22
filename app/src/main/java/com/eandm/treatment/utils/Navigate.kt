package com.eandm.treatment.utils

import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

sealed class Navigate {

    data class ToDirection(val directionId: DirectionId, val bundle: Bundle? = null) : Navigate()

    object Up : Navigate()

    object Recreate : Navigate()
}