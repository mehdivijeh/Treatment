package com.eandm.treatment.ui.treatment.reminder.duration

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.eandm.treatment.R
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_select_duration.*
import java.util.*


@AndroidEntryPoint
class SelectDurationFragment : Fragment(R.layout.fragment_select_duration) {

    private val selectDurationViewModel by viewModels<SelectDurationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lil_start_date.setOnClickListener {
            selectDurationViewModel.onStartDateClick()
        }

        selectDurationViewModel.apply {
            datePickerObservable.observe(viewLifecycleOwner, ::showDatePicker)
            durationViewStateObservable.observe(viewLifecycleOwner, ::handleDurationView)
        }

        rgp_duration.setOnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById(checkedId) as RadioButton
            val selectedRadioButtonTitle = checkedRadioButton.text.toString()
            selectDurationViewModel.onRadioButtonCheck(selectedRadioButtonTitle)
        }

        img_back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun showDatePicker(date: Date) {
        val calendar = Calendar.getInstance().apply {
            time = date
        }
        val constraintsBuilder = CalendarConstraints.Builder().setStart(calendar.timeInMillis)
        val datePicker = MaterialDatePicker
            .Builder
            .datePicker()
            .setCalendarConstraints(constraintsBuilder.build())
            .build()
        datePicker.show(childFragmentManager, datePicker.tag)

        datePicker.addOnPositiveButtonClickListener {

        }
    }

    private fun handleDurationView(durationViewState: DurationViewState) {
        durationViewState.apply {
            with(lil_until) {
                isVisible = isUntilViewIsVisible
            }
            with(lil_duration) {
                isVisible = isDurationViewIsVisible
            }
            with(divider_secondary) {
                isVisible = isUntilViewIsVisible || isDurationViewIsVisible
            }
        }
    }
}