package com.eandm.treatment.ui.treatment.reminder

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.eandm.treatment.R
import com.eandm.treatment.utils.Constants.ARG_ADD_REMINDER_DATA
import com.eandm.treatment.utils.observeNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_reminder.*

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