package com.example.project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.jar.Attributes;

@Dao
public interface DataDao {
    @Query("SELECT * FROM Data")
    List<Data>getAll();
    @Insert
    void insert(Data data);

    @Delete
    void delete(Data data);

    @Update
    void update(Data data);

}



