package com.example.childvaccination;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.vaccine.R;

public class ScheduleActivity extends AppCompatActivity {

    private Button schedule;
    private ImageButton rem, rem2, rem3, rem4, rem5, rem6, rem7;
    private String childName = "";
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