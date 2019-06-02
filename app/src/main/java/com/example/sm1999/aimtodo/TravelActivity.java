package com.example.sm1999.aimtodo;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sm1999.aimtodo.Utils.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TravelActivity extends AppCompatActivity {
    private static final String TAG = "TravelActivity";

    DatabaseHelper databaseHelper;
    Button addNewData;
    EditText newTodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        getSupportActionBar().setTitle("Travel");
        databaseHelper = new DatabaseHelper(this);

        addNewData = findViewById(R.id.saveTodo);
        newTodo = findViewById(R.id.newTraveltodo);
        addNewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c);
                String traveltodo = newTodo.getText().toString();
                boolean insertData = databaseHelper.addData(traveltodo+" "+formattedDate,"","","","","","","");

                if(insertData){
                    Toast.makeText(TravelActivity.this, "To-do Successfully stored!", Toast.LENGTH_SHORT).show();
                    newTodo.setText("");
                }
                else{
                    Toast.makeText(TravelActivity.this, "Error in storing data!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
