package com.eandm.treatment.di

import com.eandm.treatment.utils.ResourceProvider
import com.eandm.treatment.utils.input.StringArg
import com.eandm.treatment.utils.input.StringArrayId
import com.eandm.treatment.utils.input.StringId
import com.eandm.treatment.utils.provider.StringArgToStringResource
import com.eandm.treatment.utils.provider.StringArrayToStringResource
import com.eandm.treatment.utils.provider.StringIdToStringResource
import com.eandm.treatment.utils.resource.StringArrayResource
import com.eandm.treatment.utils.resource.StringResource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface ResourcesModule {

    @Binds
    fun bindStringIdToStringResource(
        input: StringIdToStringResource
    ): ResourceProvider<StringId, StringResource>

    @Binds
    fun bindStringArgToStringResource(
        input: StringArgToStringResource
    ): ResourceProvider<StringArg, StringResource>

    @Binds
    fun bindStringArrayToStringResource(
        input: StringArrayToStringResource
    ): ResourceProvider<StringArrayId, StringArrayResource>

}