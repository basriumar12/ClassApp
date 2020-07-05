package com.testing.classapp.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.testing.classapp.model.ClassModel;

import java.util.List;



@Dao
public interface ClassDao {

    // Mengambil data
    @Query("SELECT * FROM KELAS ORDER BY nama_kelas ASC")
    List<ClassModel> select();

    // Memasukkan data
    @Insert
    void insert(ClassModel classModel);

    // Menghapus data
    @Delete
    void delete(ClassModel classModel);

    // Mengupdate data
    @Update
    void update(ClassModel classModel);


}
