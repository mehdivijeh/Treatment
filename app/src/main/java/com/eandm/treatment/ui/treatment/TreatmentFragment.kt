package com.eandm.treatment.ui.treatment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.eandm.treatment.R
import com.eandm.treatment.ui.treatment.type.TreatmentTypeBottomSheet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_treatment.*

@AndroidEntryPoint
class TreatmentFragment : Fragment(R.layout.fragment_treatment) {

    private val treatmentViewModel by viewModels<TreatmentViewModel>()

    private val treatmentTypeViewModel by viewModels<TreatmentTypeViewModel>()

    private var treatmentTypeBottomSheet: TreatmentTypeBottomSheet? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBottomSheet()

        fab_add_treatment.setOnClickListener {
            treatmentTypeBottomSheet?.show()
        }
    }

    private fun initBottomSheet(){
        treatmentTypeBottomSheet = TreatmentTypeBottomSheet(
            requireContext(),
            treatmentTypeViewModel,
            viewLifecycleOwner,
            {
                findNavController().navigate(R.id.action_treatment_fragment_to_add_treatment_fragment)
            }
        )
    }
}