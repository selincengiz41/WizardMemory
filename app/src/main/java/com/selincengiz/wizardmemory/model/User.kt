package com.selincengiz.wizardmemory.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Users")
data class User (
    @ColumnInfo(name = "name")
    var Name :String?,

    @ColumnInfo(name = "email")
    var email :String?,
    @ColumnInfo(name = "password")
    var password :String?,
        ):Serializable
{
    @PrimaryKey(autoGenerate = true)
    var uuid :Int =0
}