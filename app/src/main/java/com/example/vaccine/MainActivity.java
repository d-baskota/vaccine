package com.example.vaccine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.childvaccination.AlarmBroadCastReciever;
import com.example.childvaccination.ChildDetails;
import com.example.childvaccination.InformationActivity;

public class MainActivity extends AppCompatActivity {
    private Button button2;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.scheduler_button);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scheduleIntent = new Intent(MainActivity.this, ChildDetails.class);
                startActivity(scheduleIntent);
            }
        });

        button1 = findViewById(R.id.information_button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scheduleIntent = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(scheduleIntent);
            }
        });
    }
}

