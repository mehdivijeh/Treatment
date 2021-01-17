package com.eandm.treatment.ui.treatment

import com.eandm.treatment.data.TreatmentType

interface TreatmentRepository {
    fun getTreatmentType(): List<TreatmentType>
}