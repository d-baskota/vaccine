package com.example.childvaccination;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.vaccine.R;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.app.ProgressDialog.show;

public class ChildinfoActivity extends AppCompatActivity {
    private Button add;
    private EditText name;
    private EditText dob;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childinfo);
        getSupportActionBar().hide();

        dob = (EditText) findViewById(R.id.dob);

        setDateTimeField();

        dob.setOnTouchListener(new View.OnTouchListener() {

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

                dob.setText(fdate);

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }

    RadioButton selectBtn;
    private void addListenerOnButton() {
        radioGroup = (RadioGroup)findViewById(R.id.gender);
        add = (Button)findViewById(R.id.add);
        name = (EditText) findViewById(R.id.name);
        dob = (EditText) findViewById(R.id.dob);
        textView = (TextView) findViewById(R.id.textView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectBtn = group.findViewById(checkedId);
            }
        });

            add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    //            Toast.makeText(ChildinfoActivity.this,
      //                name.getText(), Toast.LENGTH_SHORT).show();
        //        Toast.makeText(ChildinfoActivity.this,
          //            dob.getText(), Toast.LENGTH_SHORT).show();
            //    Toast.makeText(ChildinfoActivity.this,
              //        selectBtn.getText(), Toast.LENGTH_SHORT).show();
                //Log.i(TAG, "name: "+name.getText().toString()+dob.getText().toString()+selectBtn.getText().toString());
//                Log.i(TAG, "dob: "+dob.getText().toString());
  //              Log.i(TAG, "onClick: "+selectBtn.getText().toString());

                if (selectBtn == null){
                    return;
                }

                SharePreferences.setChild(getApplicationContext(),name.getText().toString(),dob.getText().toString(),selectBtn.getText().toString());
                Log.i("shared", "onClick: ");
                Childinfo info = new  Childinfo(name.getText().toString(),dob.getText().toString(),selectBtn.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("data",info);
                setResult(Activity.RESULT_OK,intent);
                finish();
             //   textView.setText("\n Name :\t" + name.getText().toString() + "\nDate Of Birth :\t " + dob.getText().toString() + "\nGender :\t " + selectBtn.getText().toString());
            }
        });
    }

    private static final String TAG = "ChildinfoActivity";
}
