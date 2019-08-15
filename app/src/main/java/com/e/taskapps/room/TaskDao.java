package com.e.taskapps.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.e.taskapps.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task ORDER by id DESC")
    LiveData<List<Task>> getAll();

    @Query("SELECT * FROM Task WHERE id = :id")
    Task getById (long id);

    @Update
    void update (Task task);

    @Insert
    void insert(Task task);

    @Delete
    void delete(Task task);


}




