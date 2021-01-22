package com.eandm.treatment.ui.treatment.reminder.duration

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eandm.treatment.R
import com.eandm.treatment.ui.treatment.TreatmentRepository
import com.eandm.treatment.utils.ResourceProvider
import com.eandm.treatment.utils.SingleLiveData
import com.eandm.treatment.utils.input.StringId
import com.eandm.treatment.utils.resource.StringResource
import java.lang.IllegalStateException
import java.util.*

class SelectDurationViewModel @ViewModelInject constructor(
    private val treatmentRepository: TreatmentRepository,
    private val stringResourceProvider: ResourceProvider<StringId, StringResource>
) : ViewModel() {

    private val _datePickerObservable = SingleLiveData<Date>()
    val datePickerObservable: LiveData<Date> = _datePickerObservable

    private val _durationViewStateObservable = MutableLiveData(DurationViewState())
    val durationViewStateObservable: LiveData<DurationViewState> = _durationViewStateObservable


    fun onStartDateClick() {
        _datePickerObservable.value = Calendar.getInstance().time
    }

    fun onRadioButtonCheck(checkedTitle: String) {
        _durationViewStateObservable.value = when (checkedTitle) {
            stringResourceProvider.getResource(StringId(R.string.no_end_date))
                .resource -> {
                requireNotNull(_durationViewStateObservable.value)
                    .copy(isDurationViewIsVisible = false, isUntilViewIsVisible = false)
            }
            stringResourceProvider.getResource(StringId(R.string.until_date))
                .resource -> {
                requireNotNull(_durationViewStateObservable.value)
                    .copy(isDurationViewIsVisible = false, isUntilViewIsVisible = true)
            }
            stringResourceProvider.getResource(StringId(R.string.for_x_days))
                .resource -> {
                requireNotNull(_durationViewStateObservable.value)
                    .copy(isDurationViewIsVisible = true, isUntilViewIsVisible = false)
            }
            else -> throw IllegalStateException("illegal state $checkedTitle")
        }
    }
}