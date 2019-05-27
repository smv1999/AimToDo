package com.example.sm1999.aimtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sm1999.aimtodo.Utils.DatabaseHelper;

public class StudiesActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    Button addNewData;
    EditText newTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies);

        getSupportActionBar().setTitle("Studies");

        databaseHelper = new DatabaseHelper(this);

        addNewData = findViewById(R.id.saveTodo);
        newTodo = findViewById(R.id.newStudiestodo);
        addNewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studytodo = newTodo.getText().toString();
                boolean insertData = databaseHelper.addData("","","","","","",studytodo,"");

                if(insertData){
                    Toast.makeText(StudiesActivity.this, "To-do Successfully stored!", Toast.LENGTH_SHORT).show();
                    newTodo.setText("");
                }
                else{
                    Toast.makeText(StudiesActivity.this, "Error in storing data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
