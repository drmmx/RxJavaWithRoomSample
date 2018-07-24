package com.drmmx.devmaks.rxjavawithroomsample.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.drmmx.devmaks.rxjavawithroomsample.R;
import com.drmmx.devmaks.rxjavawithroomsample.database.Employee;
import com.drmmx.devmaks.rxjavawithroomsample.remote.DataCallback;
import com.drmmx.devmaks.rxjavawithroomsample.remote.DataManager;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataCallback{

    private Button mGetDataButton;
    private Button mAddDataButton;
    private ListView mListView;
    private CustomAdapter mCustomAdapter;

    private DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGetDataButton = findViewById(R.id.getDataButton);
        mAddDataButton = findViewById(R.id.addDataButton);
        mListView = findViewById(R.id.listView);

        mDataManager = new DataManager(this);

        mAddDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataManager.addData(MainActivity.this, "firstOne", "lastOne");
            }
        });

        mGetDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataManager.loadData(MainActivity.this);
            }
        });

    }

    @Override
    public void dataAdded() {
        Toast.makeText(this, "Data added", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorAdded() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadEmployeeData(List<Employee> employeeList) {
        mCustomAdapter = new CustomAdapter(this, employeeList);
        mListView.setAdapter(mCustomAdapter);
    }
}
