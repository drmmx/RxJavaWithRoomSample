package com.drmmx.devmaks.rxjavawithroomsample.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.drmmx.devmaks.rxjavawithroomsample.R;
import com.drmmx.devmaks.rxjavawithroomsample.database.Employee;

import java.util.List;

/**
 * Created by dev3rema
 */
public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    private List<Employee> mEmployeeList;
    private LayoutInflater mLayoutInflater;

    public CustomAdapter(Context context, List<Employee> employeeList) {
        mContext = context;
        mEmployeeList = employeeList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mEmployeeList.size();
    }

    @Override
    public Object getItem(int i) {
        return mEmployeeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.inner_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.firstName = view.findViewById(R.id.firstName);
            viewHolder.lastName = view.findViewById(R.id.lastName);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Employee employee = (Employee) getItem(i);
        viewHolder.firstName.setText(employee.getFirstName());
        viewHolder.lastName.setText(employee.getLastName());

        return view;
    }

    public class ViewHolder {
        TextView firstName;
        TextView lastName;
    }
}
