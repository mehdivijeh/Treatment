package com.eandm.treatment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Treatment(
    @PrimaryKey(autoGenerate = true)
    val id: Long
)