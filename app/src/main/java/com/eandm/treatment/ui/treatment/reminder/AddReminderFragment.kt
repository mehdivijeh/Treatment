package com.eandm.treatment.ui.treatment.reminder

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.eandm.treatment.R
import com.eandm.treatment.ui.treatment.type.HourPickerDialog
import com.eandm.treatment.utils.Constants.ARG_ADD_REMINDER_DATA
import com.eandm.treatment.utils.dateToGregorian
import com.eandm.treatment.utils.observeNavigation
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_reminder.*
import kotlinx.android.synthetic.main.fragment_add_reminder.img_back
import kotlinx.android.synthetic.main.fragment_add_reminder.lil_duration
import kotlinx.android.synthetic.main.fragment_add_reminder.txt_toolbar
import kotlinx.android.synthetic.main.fragment_select_duration.*
import java.util.*

@AndroidEntryPoint
class AddReminderFragment : Fragment(R.layout.fragment_add_reminder) {

    private val addReminderViewModel by viewModels<AddReminderViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addReminderData =
            requireArguments().getParcelable<AddReminderData>(ARG_ADD_REMINDER_DATA)
        addReminderViewModel.setAddReminderData(addReminderData!!)

        addReminderViewModel.apply {
            reminderTitleObservable.observe(viewLifecycleOwner, ::applyTitle)
            reminderPrimaryValueObservable.observe(viewLifecycleOwner, ::applyPrimaryValue)
            navigateToSelectDurationObservable.observeNavigation(this@AddReminderFragment)
        }

        lil_duration.setOnClickListener {
            addReminderViewModel.onDurationClick()
        }

        lil_reminder.setOnClickListener {
            HourPickerDialog.showDialog(requireContext() , layoutInflater , "" , "")
        }

        img_back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun applyTitle(title: String) {
        txt_toolbar.apply {
            text = title
        }
    }

    private fun applyPrimaryValue(reminderPrimaryValue: ReminderPrimaryValue) {
        txt_primary_title.apply {
            text = reminderPrimaryValue.name
        }
        txt_primary_unit.apply {
            text = reminderPrimaryValue.unit
        }
    }

}