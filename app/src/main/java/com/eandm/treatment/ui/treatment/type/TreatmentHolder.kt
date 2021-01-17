package com.eandm.treatment.ui.treatment.type

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.eandm.treatment.data.TreatmentType
import kotlinx.android.synthetic.main.item_treatment_type.view.*

class TreatmentHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val itemIcon: AppCompatImageView = view.itemIcon
    private val itemTitle: AppCompatTextView = view.itemTitle

    fun bind(item: TreatmentType, onClick: (Int) -> Unit) {
        itemIcon.setImageResource(item.itemIconResource)
        itemTitle.setText(item.itemTitleResource)
        itemView.setOnClickListener {
            onClick.invoke(item.id)
        }
    }
}