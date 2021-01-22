package com.eandm.treatment.ui.treatment.add.medication

import android.os.Bundle
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eandm.treatment.R
import com.eandm.treatment.ui.treatment.TreatmentRepository
import com.eandm.treatment.ui.treatment.reminder.AddReminderData
import com.eandm.treatment.ui.treatment.reminder.ReminderType
import com.eandm.treatment.utils.*
import com.eandm.treatment.utils.Constants.ARG_ADD_REMINDER_DATA
import com.eandm.treatment.utils.input.StringArrayId
import com.eandm.treatment.utils.resource.StringArrayResource
import java.util.Collections.copy

class SelectMedicationViewModel @ViewModelInject constructor(
    private val treatmentRepository: TreatmentRepository,
    private val stringArrayResourceProvider: ResourceProvider<StringArrayId, StringArrayResource>
) : ViewModel() {

    private val _medicationUnitObservable = MutableLiveData<StringArrayResource>()
    val medicationUnitObservable: LiveData<StringArrayResource> = _medicationUnitObservable

    private val _viewStateObservable = MutableLiveData(InputMedicationNameViewState())
    val viewStateObservable: LiveData<InputMedicationNameViewState> = _viewStateObservable

    private val _navigateToAddMedicationObservable = SingleLiveData<Navigate>()
    val navigateToAddMedicationObservable: LiveData<Navigate> = _navigateToAddMedicationObservable

    init {
        _medicationUnitObservable.value = selectMedicationUnits()
    }

    private fun selectMedicationUnits(): StringArrayResource {
        val medicationUnitId = StringArrayId(R.array.medication_type)
        return stringArrayResourceProvider.getResource(medicationUnitId)
    }

    fun onMedicationNameTextChange(text: CharSequence?) {
        _viewStateObservable.value = if (text?.isNotEmpty() == true) {
            requireNotNull(_viewStateObservable.value)
                .copy(isNextButtonEnabled = true)
        } else {
            requireNotNull(_viewStateObservable.value)
                .copy(isNextButtonEnabled = false)
        }
    }

    fun onNextClick(title: String, unit: String) {
        val directionId =
            DirectionId(R.id.action_select_treatment_fragment_to_add_reminder_fragment)
        val addReminderData = AddReminderData(title, unit, ReminderType.AddMedication)
        val bundle = Bundle()
        bundle.putParcelable(ARG_ADD_REMINDER_DATA, addReminderData)
        _navigateToAddMedicationObservable.value =
            Navigate.ToDirection(directionId, bundle)
    }

}