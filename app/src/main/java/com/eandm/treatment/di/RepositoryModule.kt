package com.eandm.treatment.di

import com.eandm.treatment.ui.treatment.TreatmentRepository
import com.eandm.treatment.ui.treatment.TreatmentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
internal abstract class RepositoryModule {
    @Binds
    abstract fun providesChannelRepository(treatmentRepositoryImpl: TreatmentRepositoryImpl): TreatmentRepository
}