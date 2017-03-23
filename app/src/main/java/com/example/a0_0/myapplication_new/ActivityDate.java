package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class ActivityDate extends Activity {
    private EditText et;
    private Calendar calendar;
    private  int year;
    private  int month;
    private  int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        et=(EditText)findViewById(R.id.et);
        calendar=calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
    }
    public void showDate(View view){
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                et.setText(year+"年"+(month+1)+"月"+dayOfMonth+"日");
            }
        },year,month,day).show();
    }
}
