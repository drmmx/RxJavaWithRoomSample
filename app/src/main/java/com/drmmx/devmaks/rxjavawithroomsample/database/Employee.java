package com.drmmx.devmaks.rxjavawithroomsample.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by dev3rema
 */
@Entity(tableName = "employee")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "firstname")
    public String firstName;

    @ColumnInfo(name = "lastname")
    public String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
