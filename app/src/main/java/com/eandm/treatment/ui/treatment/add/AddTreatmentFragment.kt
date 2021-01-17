package com.eandm.treatment.ui.treatment.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.eandm.treatment.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTreatmentFragment : Fragment(R.layout.fragment_add_treatment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findNavController().navigate(R.id.action_add_treatment_fragment_to_add_medication_dialog)
    }
}