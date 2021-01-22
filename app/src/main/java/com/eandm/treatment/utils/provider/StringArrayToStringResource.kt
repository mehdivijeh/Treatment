package com.eandm.treatment.utils.provider

import android.content.Context
import com.eandm.treatment.utils.ResourceProvider
import com.eandm.treatment.utils.input.StringArrayId
import com.eandm.treatment.utils.resource.StringArrayResource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StringArrayToStringResource @Inject constructor(
    @ApplicationContext private val context: Context
) : ResourceProvider<StringArrayId, StringArrayResource> {

    override fun getResource(input: StringArrayId): StringArrayResource {
        return StringArrayResource(context.resources.getStringArray(input.arrayId))
    }
}