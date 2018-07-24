package com.drmmx.devmaks.rxjavawithroomsample.remote;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.drmmx.devmaks.rxjavawithroomsample.database.Employee;
import com.drmmx.devmaks.rxjavawithroomsample.database.EmployeeDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dev3rema
 */
public class DataManager {

    private Context mContext;

    private EmployeeDatabase mDatabase;

    public DataManager(Context context) {
        mContext = context;
        mDatabase = Room.databaseBuilder(context, EmployeeDatabase.class, "employee.db").build();
    }

    public void addData(final DataCallback dataCallback, final String firstName, final String lastName) {

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {

                Employee employee = new Employee(firstName, lastName);
                mDatabase.getEmloyeeDao().insert(employee);

            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
        .subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

                dataCallback.dataAdded();

            }

            @Override
            public void onError(Throwable e) {

                dataCallback.errorAdded();

            }
        });

    }

    public void loadData(final DataCallback dataCallback) {
        mDatabase.getEmloyeeDao().getEmployee().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Employee>>() {
            @Override
            public void accept(List<Employee> employeeList) throws Exception {
                dataCallback.loadEmployeeData(employeeList);
            }
        });
    }
}
