package com.example.childvaccination;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import com.example.vaccine.R;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {

    private Button schedule;
    private ImageButton rem, rem2, rem3, rem4, rem5, rem6, rem7;
    private String childName = "";
    private CheckBox checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        getSupportActionBar().hide();
        childName = getIntent().getStringExtra("CHILD_NAME");

        schedule = findViewById(R.id.viewSchedule);
        rem = findViewById(R.id.reminder);
        rem2 = findViewById(R.id.reminder2);
        rem3 = findViewById(R.id.reminder3);
        rem4 = findViewById(R.id.reminder4);
        rem5 = findViewById(R.id.reminder5);
        rem6 = findViewById(R.id.reminder6);
        rem7 = findViewById(R.id.reminder7);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);

        try{
            ArrayList<CompoundButtonClass> checkList = SharePreferences.getCompountButtonPref(this);
            if(checkList != null){
                for (CompoundButtonClass ele:checkList
                ) {
                    if(ele.childName.equals(childName)){
                        checkBox.setChecked(ele.check1);
                        checkBox2.setChecked(ele.check2);
                        checkBox3.setChecked(ele.check3);
                        checkBox4.setChecked(ele.check4);
                        checkBox5.setChecked(ele.check5);
                        checkBox6.setChecked(ele.check6);
                        checkBox7.setChecked(ele.check7);
                    }
                }
            }
        } catch (Exception e){

        }



        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scheduleIntent = new Intent(ScheduleActivity.this, SchedulesDate.class);
                scheduleIntent.putExtra("CHILD_NAME", childName);
                startActivity(scheduleIntent);
            }
        }
        );

        rem.setOnClickListener(formClicked);

        rem2.setOnClickListener(formClicked);

        rem3.setOnClickListener(formClicked);

        rem4.setOnClickListener(formClicked);

        rem5.setOnClickListener(formClicked);

        rem6.setOnClickListener(formClicked);

        rem7.setOnClickListener(formClicked);

        checkBox.setOnCheckedChangeListener(onCheckChange);
        checkBox2.setOnCheckedChangeListener(onCheckChange);
        checkBox3.setOnCheckedChangeListener(onCheckChange);
        checkBox4.setOnCheckedChangeListener(onCheckChange);
        checkBox5.setOnCheckedChangeListener(onCheckChange);
        checkBox6.setOnCheckedChangeListener(onCheckChange);
        checkBox7.setOnCheckedChangeListener(onCheckChange);
    }

    private CompoundButton.OnCheckedChangeListener onCheckChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            changeCompoundButtonPref();
        }
    };

    private void changeCompoundButtonPref() {
        Boolean isValueChanged = false;
        ArrayList<CompoundButtonClass> checkList = SharePreferences.getCompountButtonPref(this);
        if(checkList != null){
            for (CompoundButtonClass ele:checkList
                 ) {
                if(ele.childName.equals(childName)){
                    isValueChanged = true;
                    setLatestValue(ele);
                }
            }
        } else {
            checkList = new ArrayList<>();
        }
        if(!isValueChanged){
            CompoundButtonClass compoundButtonClass = new CompoundButtonClass();
            compoundButtonClass.childName = childName;
            compoundButtonClass.check1 = checkBox.isChecked();
            compoundButtonClass.check2 = checkBox2.isChecked();
            compoundButtonClass.check3 = checkBox3.isChecked();
            compoundButtonClass.check4 = checkBox4.isChecked();
            compoundButtonClass.check5 = checkBox5.isChecked();
            compoundButtonClass.check6 = checkBox6.isChecked();
            compoundButtonClass.check7 = checkBox7.isChecked();
            checkList.add(compoundButtonClass);
            SharePreferences.setCompoundButtonPref(this, checkList);
        } else {
            SharePreferences.setCompoundButtonPref(this, checkList);
        }

    }

    private void setLatestValue(CompoundButtonClass ele) {
        ele.check1 = checkBox.isChecked();
        ele.check2 = checkBox2.isChecked();
        ele.check3 = checkBox3.isChecked();
        ele.check4 = checkBox4.isChecked();
        ele.check5 = checkBox5.isChecked();
        ele.check6 = checkBox6.isChecked();
        ele.check7 = checkBox7.isChecked();

    }

    private View.OnClickListener formClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent scheduleIntent = new Intent(ScheduleActivity.this, ReminderForm.class);
            scheduleIntent.putExtra("CHILD_NAME", childName);
            startActivityForResult(scheduleIntent, 0);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            scheduleinfo sinfo = data.getParcelableExtra("sdata");
            // scheduledetails.add(sinfo);
            //recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}