package com.eandm.treatment.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface TreatmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(treatment: Treatment)
}