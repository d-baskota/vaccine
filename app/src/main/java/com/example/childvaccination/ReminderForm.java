package com.example.childvaccination;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.vaccine.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReminderForm extends AppCompatActivity {
    private Button setreminder;
    private EditText remdate;
    private TextView remtime;
    private EditText hospitalname;
    private EditText question;
    private TextView remView;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private TimePickerDialog timepicker;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_form);
        getSupportActionBar().hide();

        remView = (TextView) findViewById(R.id.remView);
        setreminder = (Button) findViewById(R.id.setReminder);
        remdate = (EditText) findViewById(R.id.remdate);
        remtime = (TextView) findViewById(R.id.remtime);
        hospitalname = (EditText) findViewById(R.id.hospitalname);
        question = (EditText) findViewById(R.id.question);
        remView = (TextView) findViewById(R.id.remView);

        setDateTimeField();

        remdate.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                datePickerDialog.show();
                return false;
            }
        });

        addListenerOnButton();

    }

    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                final Date startDate = newDate.getTime();
                String fdate = sd.format(startDate);

                remdate.setText(fdate);

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.nanoTime());

        remtime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                timepicker = new TimePickerDialog(ReminderForm.this,

                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                remtime.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                timepicker.show();
            }
        });

    }

    private void addListenerOnButton() {
        setreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<scheduleinfo> reminderList = new ArrayList<scheduleinfo>();
                try {
                    reminderList = SharePreferences.getReminderArrayList(ReminderForm.this);
                    if(reminderList == null){
                        reminderList = new ArrayList<scheduleinfo>();
                    }
                } catch (Exception e){
                    reminderList = new ArrayList<scheduleinfo>();
                }

                //remView.setText("\n Date :\t" + remdate.getText().toString() + "\nTime :\t " + remtime.getText().toString() + "\n Hospital :\t " + hospitalname.getText().toString() + "\n Question for Doctor :\t " + question.getText().toString());
                SharePreferences.setUserdata(getApplicationContext(), remdate.getText().toString(), remtime.getText().toString(), hospitalname.getText().toString(), question.getText().toString());

                scheduleinfo sinfo = new scheduleinfo(remdate.getText().toString(), remtime.getText().toString(), hospitalname.getText().toString(), question.getText().toString());
                reminderList.add(sinfo);
                Intent intent = new Intent();
                intent.putExtra("sdata", sinfo);
                SharePreferences.setReminderArrayList(ReminderForm.this, reminderList);
                setResult(Activity.RESULT_OK, intent);
                finish();


            }
        });
    }

    private static final String TAG = "ReminderForm";

}
