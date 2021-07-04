package com.example.adapterupdown;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void insertAll(Student ...students);

    @Insert
    void insertSingleStudent(Student student);

    @Delete
    void delete(Student student);

    @Query("SELECT * FROM students")
    List<Student> getAll();
}
