package com.example.lianghao.testtwo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by LiangHao on 2016/10/10.
 * view mode 数据跟新
 */

public class Employee  extends BaseObservable{
    String FirstName;
    String LastName;
    @Bindable
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
       notifyChange();
    }
     @Bindable
    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
        notifyChange();
    }

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    public Employee(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }
}
