package com.eandm.treatment.utils.provider

import android.content.Context
import com.eandm.treatment.utils.ResourceProvider
import com.eandm.treatment.utils.input.StringArg
import com.eandm.treatment.utils.resource.StringResource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StringArgToStringResource @Inject constructor(
    @ApplicationContext private val context: Context
) : ResourceProvider<StringArg, StringResource> {

    override fun getResource(input: StringArg): StringResource {
        return StringResource(context.getString(input.stringId, *input.stringArgs))
    }
}