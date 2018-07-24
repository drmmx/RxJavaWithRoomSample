package com.drmmx.devmaks.rxjavawithroomsample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by dev3rema
 */
@Database(entities = Employee.class, version = 1)
public abstract class EmployeeDatabase extends RoomDatabase{

    public abstract EmployeeDao getEmloyeeDao();

}
