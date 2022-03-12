package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import androidx.room.Query
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query(value = "SELECT * FROM items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query(value = "SELECT * FROM items")
    fun getItems(): Flow<List<Item>>
}
