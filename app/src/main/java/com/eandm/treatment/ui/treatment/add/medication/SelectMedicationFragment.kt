package com.eandm.treatment.ui.treatment.add.medication

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.eandm.treatment.R
import com.eandm.treatment.utils.Navigate
import com.eandm.treatment.utils.observeNavigation
import com.eandm.treatment.utils.resource.StringArrayResource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_select_medication.*

@AndroidEntryPoint
class SelectMedicationFragment : Fragment(R.layout.fragment_select_medication) {

    private val selectMedicationViewModel by viewModels<SelectMedicationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edt_medication_name.addTextChangedListener(onTextChanged = { text, _, _, _ ->
            selectMedicationViewModel.onMedicationNameTextChange(text)
        })

        btn_next.setOnClickListener {
            val title = edt_medication_name.text.toString()
            val unit = spn_medication_unit.text.toString()
            selectMedicationViewModel.onNextClick(title, unit)
        }

        selectMedicationViewModel.apply {
            viewStateObservable.observe(viewLifecycleOwner, ::handleViewState)
            medicationUnitObservable.observe(viewLifecycleOwner, ::fillMedicationUnitSpinner)
            navigateToAddMedicationObservable.observeNavigation(this@SelectMedicationFragment)
        }
    }

    private fun fillMedicationUnitSpinner(medicationUnit: StringArrayResource) {
        spn_medication_unit.apply {
            setAdapter(
                SpinnerAdapter(
                    requireActivity(),
                    medicationUnit.resource
                )
            )
        }
    }

    private fun handleViewState(viewState: InputMedicationNameViewState) {
        viewState.apply {
            with(group_next_action) {
                isVisible = isNextButtonEnabled
            }
        }
    }
}