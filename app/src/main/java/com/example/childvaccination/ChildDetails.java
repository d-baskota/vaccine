package com.example.childvaccination;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vaccine.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.ArrayList;

public class ChildDetails extends AppCompatActivity {

    private FloatingActionButton buttonf;
    private Button add;
    private ArrayList<Childinfo> details = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChildinfoAdapter childinfoAdapter;

    SharePreferences sharePreferences;

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_details);
        getSupportActionBar().hide();

        buttonf = findViewById(R.id.floatingActionButton);
        add = findViewById(R.id.Add);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scheduleIntent = new Intent(ChildDetails.this,ChildinfoActivity.class);
                //startActivity(scheduleIntent);
                startActivityForResult(scheduleIntent,0);
            }
        });

        String name = SharePreferences.getName(this);
        String dob = SharePreferences.getDob(this);
        String gender = SharePreferences.getGender(this);

        recyclerView =(RecyclerView) findViewById(R.id.list);

        childinfoAdapter =new ChildinfoAdapter(ChildDetails.this, details);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);

        Childinfo info = new Childinfo(name, dob, gender);

        //recyclerView.setAdapter(childinfoAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(childinfoAdapter);

//        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Intent scheduleIntent = new Intent(ChildDetails.this,ScheduleActivity.class);
//                startActivity(scheduleIntent);
//
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));

        try{
            ArrayList<Childinfo> a = SharePreferences.getArrayList(getApplicationContext());
            details.addAll(a);
            childinfoAdapter.notifyDataSetChanged();

        } catch (Exception e){

        }

        //prepareChildData();

    }

    private static final String TAG = "ChildDetails";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
     //   Log.i(TAG, "onActivityResult: "+requestCode +"  "+resultCode);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK){
            Childinfo info = data.getParcelableExtra("data");
            details.add(info);

            SharePreferences.setArrayList(getApplicationContext(), details);
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    private void prepareChildData() {

        Childinfo childinfo = new Childinfo("Ram", "2020-2-4", "Male");
        details.add(childinfo);

        childinfo = new Childinfo("Shyam", "2019-4-3", "Male");
        details.add(childinfo);

        childinfo = new Childinfo("Sita", "2019-3-30", "Female");
        details.add(childinfo);

        childinfo = new Childinfo("Radha", "2019-2-26", "Female");
        details.add(childinfo);

        childinfo = new Childinfo("Krishna", "2018-7-21", "Male");
        details.add(childinfo);

        childinfo = new Childinfo("Shyam", "2019-4-3", "Male");
        details.add(childinfo);

        childinfo = new Childinfo("Sita", "2019-3-30", "Female");
        details.add(childinfo);

        childinfo = new Childinfo("Radha", "2019-2-26", "Female");
        details.add(childinfo);

        childinfo = new Childinfo("Krishna", "2018-7-21", "Male");
        details.add(childinfo);

        childinfo = new Childinfo("Radha", "2019-2-26", "Female");
        details.add(childinfo);

        childinfo = new Childinfo("Krishna", "2018-7-21", "Male");
        details.add(childinfo);

        childinfo = new Childinfo("Shyam", "2019-4-3", "Male");
        details.add(childinfo);

        childinfo = new Childinfo("Sita", "2019-3-30", "Female");
        details.add(childinfo);

        childinfo = new Childinfo("Radha", "2019-2-26", "Female");
        details.add(childinfo);

        childinfo = new Childinfo("Krishna", "2018-7-21", "Male");
        details.add(childinfo);

        recyclerView.getAdapter().notifyDataSetChanged();
    }
}