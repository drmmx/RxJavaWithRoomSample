package com.drmmx.devmaks.rxjavawithroomsample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by dev3rema
 */
@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employee")
    Flowable<List<Employee>> getEmployee();

    @Insert
    void insert(Employee employee);

    @Delete
    void delete(Employee employee);

}
