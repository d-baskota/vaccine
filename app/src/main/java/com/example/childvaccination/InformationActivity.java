package com.example.childvaccination;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {

    private ArrayList<InfoDetail> brief = new ArrayList<>();
    private RecyclerView recyclerView;
    private InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        getSupportActionBar().hide();

            recyclerView = (RecyclerView) findViewById(R.id.infooo) ;

            infoAdapter = new InfoAdapter(brief);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

            recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

            recyclerView.setAdapter(infoAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent scheduleIntent = new Intent(InformationActivity.this,InformationDetailsActivity.class);
                startActivity(scheduleIntent);
            }
            @Override
            public void onLongClick(View view, int position) {

            }
        }));

            prepareInfoList();
        }

    private void prepareInfoList() {
    InfoDetail infoDetail = new InfoDetail("Child Vaccine and Its Importance", "- Department of immunization");
            brief.add(infoDetail);

        infoDetail = new InfoDetail("feeding table for newly born child and new mother", "- Department of health");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("caring tips for new mother", "- Department of health");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("Child Vaccine and Its Importance", "- Department of immunization");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("feeding table for newly born child and new mother", "- Department of health");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("caring tips for new mother", "- Department of health");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("Child Vaccine and Its Importance", "- Department of immunization");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("feeding table for newly born child and new mother", "- Department of health");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("caring tips for new mother", "- Department of health");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("Child Vaccine and Its Importance", "- Department of immunization");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("feeding table for newly born child and new mother", "- Department of health");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("caring tips for new mother", "- Department of health");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("Child Vaccine and Its Importance", "- Department of immunization");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("feeding table for newly born child and new mother", "- Department of health");
        brief.add(infoDetail);

        infoDetail = new InfoDetail("caring tips for new mother", "- Department of health");
        brief.add(infoDetail);

        recyclerView.getAdapter().notifyDataSetChanged();
    }
}