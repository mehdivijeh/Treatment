package com.eandm.treatment.ui.treatment.add

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.eandm.treatment.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddMedicationDialog : DialogFragment() {

    private val addTreatmentViewModel by viewModels<AddTreatmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_add_medication, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

}