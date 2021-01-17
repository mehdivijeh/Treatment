package com.eandm.treatment.ui.treatment.type

import android.content.Context
import android.view.LayoutInflater
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eandm.treatment.R
import com.eandm.treatment.ui.treatment.TreatmentTypeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class TreatmentTypeBottomSheet(
    context: Context,
    treatmentTypeViewModel: TreatmentTypeViewModel,
    lifecycleOwner: LifecycleOwner,
    onClick: (Int) -> Unit
) : BottomSheetDialog(context, R.style.AppBottomSheetDialogTheme) {

    init {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.bottom_sheet_treatment_type, null, false)
        val recyclerViewTreatmentType =
            view.findViewById<RecyclerView>(R.id.recycler_treatment_type)
        setContentView(view)
        treatmentTypeViewModel.getTreatmentTypeData()
        treatmentTypeViewModel.treatmentTypeObservable.observe(lifecycleOwner) {
            recyclerViewTreatmentType.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = TreatmentTypeAdapter(it, onClick)
            }
        }
    }

}