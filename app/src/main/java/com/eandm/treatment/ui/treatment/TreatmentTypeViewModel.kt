package com.eandm.treatment.ui.treatment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eandm.treatment.data.TreatmentType

class TreatmentTypeViewModel @ViewModelInject constructor(private val treatmentRepository: TreatmentRepository) :
    ViewModel() {

    private val _treatmentTypeObservable = MutableLiveData<List<TreatmentType>>()
    val treatmentTypeObservable: MutableLiveData<List<TreatmentType>> = _treatmentTypeObservable

    fun getTreatmentTypeData() {
        _treatmentTypeObservable.value = treatmentRepository.getTreatmentType()
    }
}