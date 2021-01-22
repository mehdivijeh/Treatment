package com.eandm.treatment.ui.treatment.add.medication

import android.app.Activity
import android.content.res.Resources.Theme
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.widget.ThemedSpinnerAdapter
import com.eandm.treatment.R

class SpinnerAdapter(private val context: Activity, private val contentArray: Array<String>) :
    ArrayAdapter<String?>(
        context, android.R.layout.simple_spinner_dropdown_item, contentArray
    ), ThemedSpinnerAdapter {
    override fun getDropDownView(position: Int, convertView: View, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.layoutInflater
        val row = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false)
        val textView = row.findViewById<View>(android.R.id.text1) as TextView
        textView.setTextAppearance(context, R.style.spinner_style)
        textView.text = contentArray[position]
        return row
    }

    override fun setDropDownViewTheme(theme: Theme?) {
        super.setDropDownViewTheme(theme)
    }

    override fun getDropDownViewTheme(): Theme? {
        return super.getDropDownViewTheme()
    }
}