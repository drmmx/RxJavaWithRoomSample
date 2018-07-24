package com.drmmx.devmaks.rxjavawithroomsample.remote;

import com.drmmx.devmaks.rxjavawithroomsample.database.Employee;

import java.util.List;

/**
 * Created by dev3rema
 */
public interface DataCallback {

    void dataAdded();
    void errorAdded();

    void loadEmployeeData(List<Employee> employeeList);

}
