package com.eandm.treatment.ui.treatment.type

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.NumberPicker
import com.eandm.treatment.R

object HourPickerDialog {

    fun showDialog(
        context: Context,
        inflater: LayoutInflater,
        title: String,
        message: String
    ) {
        val d = AlertDialog.Builder(context)
        val dialogView = inflater.inflate(R.layout.hour_picker_dialog, null)
        d.setTitle(title)
        d.setMessage(message)
        d.setView(dialogView)

        val numberPickerHour = dialogView.findViewById<NumberPicker>(R.id.dialog_number_hour)
        numberPickerHour.maxValue = 12
        numberPickerHour.minValue = 1
        numberPickerHour.wrapSelectorWheel = true

        val numberPickerMin = dialogView.findViewById<NumberPicker>(R.id.dialog_number_min)
        val minArray = mutableListOf<String>()
        for (i in 0 until 60 step 5){
            if(i != 0){
                minArray.add(i.toString())
            }else{
                minArray.add("00")
            }
        }
        numberPickerMin.maxValue = minArray.size
        numberPickerMin.minValue = 1
        numberPickerMin.displayedValues = minArray.toTypedArray()
        numberPickerMin.wrapSelectorWheel = true

        val numberPickerDayState = dialogView.findViewById<NumberPicker>(R.id.dialog_number_day_state)
        numberPickerDayState.maxValue = 2
        numberPickerDayState.minValue = 1
        numberPickerDayState.displayedValues = arrayOf("AM", "PM")
        numberPickerDayState.wrapSelectorWheel = false

        d.setPositiveButton("Ok") { _, _ ->
        }
        d.setNegativeButton("Cancel") { _, _ -> }
        val alertDialog = d.create()
        alertDialog.show()
    }
}