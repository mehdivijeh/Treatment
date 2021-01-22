package com.eandm.treatment.utils.input

import androidx.annotation.StringRes
import com.eandm.treatment.utils.Input

class StringArg(
    @StringRes val stringId: Int,
    vararg val stringArgs: Any
) : Input