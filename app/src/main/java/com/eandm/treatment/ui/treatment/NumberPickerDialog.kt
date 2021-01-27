package com.eandm.treatment.ui.treatment

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.NumberPicker
import com.eandm.treatment.R

object NumberPickerDialog {

    fun showDialog(
        context: Context,
        inflater: LayoutInflater,
        title: String,
        message: String,
        onResult: (Int) -> Unit
    ) {
        val d = AlertDialog.Builder(context)
        val dialogView = inflater.inflate(R.layout.number_picker_dialog, null)
        d.setTitle(title)
        d.setMessage(message)
        d.setView(dialogView)
        val numberPicker = dialogView.findViewById<NumberPicker>(R.id.dialog_number_picker)
        numberPicker.maxValue = 100
        numberPicker.minValue = 1
        numberPicker.wrapSelectorWheel = false
        numberPicker.setOnValueChangedListener { _, _, _ -> println("onValueChange: ") }
        d.setPositiveButton("Ok") { _, _ ->
            onResult(numberPicker.value)
        }
        d.setNegativeButton("Cancel") { _, _ -> }
        val alertDialog = d.create()
        alertDialog.show()
    }
}