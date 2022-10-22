package com.merttoptas.retrofittutorial.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.merttoptas.retrofittutorial.utils.Constants

@Entity(tableName = Constants.TABLE_USER_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long? = null,
    @ColumnInfo(name = "userId") val userId: String?,
    @ColumnInfo(name = "userName") val userName: String?
)
