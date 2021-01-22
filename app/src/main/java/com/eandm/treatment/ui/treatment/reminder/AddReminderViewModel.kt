package com.eandm.treatment.ui.treatment.reminder

import android.os.Bundle
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eandm.treatment.R
import com.eandm.treatment.ui.treatment.TreatmentRepository
import com.eandm.treatment.ui.treatment.reminder.duration.DurationType
import com.eandm.treatment.ui.treatment.reminder.duration.SelectDurationData
import com.eandm.treatment.utils.*
import com.eandm.treatment.utils.input.StringArrayId
import com.eandm.treatment.utils.input.StringId
import com.eandm.treatment.utils.resource.StringArrayResource
import com.eandm.treatment.utils.resource.StringResource
import java.util.*

class AddReminderViewModel @ViewModelInject constructor(
    private val treatmentRepository: TreatmentRepository,
    private val stringResourceProvider: ResourceProvider<StringId, StringResource>,
) : ViewModel() {

    private var addReminderData: AddReminderData? = null
    private var selectDurationData : SelectDurationData? = null

    private val _reminderTitleObservable = SingleLiveData<String>()
    val reminderTitleObservable: LiveData<String> = _reminderTitleObservable

    private val _reminderPrimaryValueObservable = SingleLiveData<ReminderPrimaryValue>()
    val reminderPrimaryValueObservable: LiveData<ReminderPrimaryValue> =
        _reminderPrimaryValueObservable

    private val _navigateToSelectDurationObservable = SingleLiveData<Navigate>()
    val navigateToSelectDurationObservable: LiveData<Navigate> = _navigateToSelectDurationObservable

    init {
        selectDurationData = SelectDurationData(Date() , DurationType.NoEndDate)
    }

    fun setAddReminderData(addReminderData: AddReminderData) {
        this.addReminderData = addReminderData
        _reminderTitleObservable.value = when (addReminderData.reminderType) {
            ReminderType.AddMedication -> {
                stringResourceProvider.getResource(StringId(R.string.reminder_add_medication))
                    .resource
            }
            ReminderType.AddActivity -> {
                stringResourceProvider.getResource(StringId(R.string.reminder_add_activity))
                    .resource
            }
            ReminderType.AddMeasurement -> {
                stringResourceProvider.getResource(StringId(R.string.reminder_add_measurement))
                    .resource
            }
        }
        _reminderPrimaryValueObservable.apply {
            value = ReminderPrimaryValue(name = addReminderData.name, unit = addReminderData.unit)
        }
    }

    fun onDurationClick(){
        val directionId =
            DirectionId(R.id.action_add_reminder_fragment_to_select_duration_fragment)
        val bundle = Bundle().apply {
            putParcelable(Constants.ARG_DURATION_DATA, selectDurationData)
        }
        _navigateToSelectDurationObservable.value =
            Navigate.ToDirection(directionId, bundle)
    }
}