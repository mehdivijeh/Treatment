package com.eandm.treatment.ui.treatment

import com.eandm.treatment.R
import com.eandm.treatment.data.AppDatabase
import com.eandm.treatment.data.TreatmentType
import javax.inject.Inject

class TreatmentRepositoryImpl @Inject constructor(appDatabase: AppDatabase) : TreatmentRepository {

    private val treatmentDao = appDatabase.treatmentDao()

    override fun getTreatmentType(): List<TreatmentType> {
        val treatmentTypeList = mutableListOf<TreatmentType>()
        treatmentTypeList.add(
            TreatmentType(
                1,
                R.string.item_medication,
                R.drawable.ic_launcher_background
            )
        )
        treatmentTypeList.add(
            TreatmentType(
                2,
                R.string.item_measurement,
                R.drawable.ic_launcher_background
            )
        )
        treatmentTypeList.add(
            TreatmentType(
                3,
                R.string.item_activity,
                R.drawable.ic_launcher_background
            )
        )
        treatmentTypeList.add(
            TreatmentType(
                4,
                R.string.item_symptom_check,
                R.drawable.ic_launcher_background
            )
        )
        return treatmentTypeList.toList()
    }

}