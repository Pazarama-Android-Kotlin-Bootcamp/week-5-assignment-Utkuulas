package com.merttoptas.retrofittutorial.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.merttoptas.retrofittutorial.data.local.database.base.BaseDao
import com.merttoptas.retrofittutorial.data.local.database.entity.UserEntity
import com.merttoptas.retrofittutorial.utils.Constants

@Dao
interface UserDao : BaseDao<UserEntity> {

    @Query("SELECT * FROM ${Constants.TABLE_USER_NAME}")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM ${Constants.TABLE_USER_NAME} WHERE userId = :userId")
    fun getUserById(userId: String): UserEntity?
}