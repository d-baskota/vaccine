package com.example.childvaccination;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.childvaccination.SharePreferences.sharePrefs;

import com.example.vaccine.R;

public class SchedulesDate extends AppCompatActivity {

    private ArrayList<scheduleinfo> scheduledetails = new ArrayList<>();
    private RecyclerView recyclerView;
    private SchedularAdapter schedularAdapter;

    SharePreferences sharePreferences;
    private String childName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedules_date);
        getSupportActionBar().hide();

        String date = SharePreferences.getDate(this);
        String time = SharePreferences.getTime(this);
        String hospital = SharePreferences.getHospital(this);
        String question = SharePreferences.getQuestion(this);
        childName = getIntent().getStringExtra("CHILD_NAME");

        recyclerView = (RecyclerView) findViewById(R.id.sched);

        schedularAdapter = new SchedularAdapter(SchedulesDate.this, scheduledetails);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(schedularAdapter);

//        scheduleinfo sinfo = new scheduleinfo(date, time, hospital, question);

//        scheduledetails.add(sinfo);
//        recyclerView.getAdapter().notifyDataSetChanged();

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        try{
            ArrayList<scheduleinfo> list = SharePreferences.getReminderArrayList(getApplicationContext());
            for (scheduleinfo ele: list
                 ) {
                if(ele.childName != null){
                    if(ele.childName.equals(childName)){
                        scheduledetails.add(ele);
                    }
                }
            }
            schedularAdapter.notifyDataSetChanged();

        } catch (Exception e){
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
        //prepareSchedulelists();

    }

    private static final String TAG = "SchedulesDate";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //   Log.i(TAG, "onActivityResult: "+requestCode +"  "+resultCode);

        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            scheduleinfo sinfo = data.getParcelableExtra("sdata");
            sinfo.setRemindertime(SharePreferences.getDate(this));
            scheduledetails.add(sinfo);
            SharePreferences.setReminderArrayList(getApplicationContext(), scheduledetails);
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

}