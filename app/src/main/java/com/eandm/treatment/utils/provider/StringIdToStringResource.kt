package com.eandm.treatment.utils.provider

import android.content.Context
import com.eandm.treatment.utils.ResourceProvider
import com.eandm.treatment.utils.input.StringId
import com.eandm.treatment.utils.resource.StringResource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StringIdToStringResource @Inject constructor(
    @ApplicationContext private val context: Context
) : ResourceProvider<StringId, StringResource> {

    override fun getResource(input: StringId): StringResource {
        return StringResource(context.getString(input.id))
    }
}