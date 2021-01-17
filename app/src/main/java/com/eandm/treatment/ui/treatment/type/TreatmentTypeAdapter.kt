package com.eandm.treatment.ui.treatment.type

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eandm.treatment.R
import com.eandm.treatment.data.TreatmentType

class TreatmentTypeAdapter(
    private val items: List<TreatmentType>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<TreatmentHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreatmentHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_treatment_type, parent, false)
        return TreatmentHolder(view)
    }

    override fun onBindViewHolder(holder: TreatmentHolder, position: Int) {
        holder.bind(items[position], onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}