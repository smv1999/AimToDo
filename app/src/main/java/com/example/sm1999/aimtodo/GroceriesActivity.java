package com.example.sm1999.aimtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sm1999.aimtodo.Utils.DatabaseHelper;

public class GroceriesActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Button addNewData;
    EditText newTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);

        getSupportActionBar().setTitle("Groceries");


        databaseHelper = new DatabaseHelper(this);

        addNewData = findViewById(R.id.saveTodo);
        newTodo = findViewById(R.id.newGroceriestodo);
        addNewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groceriestodo = newTodo.getText().toString();
                boolean insertData = databaseHelper.addData("",groceriestodo,"","","","","","");

                if(insertData){
                    Toast.makeText(GroceriesActivity.this, "To-do Successfully stored!", Toast.LENGTH_SHORT).show();
                    newTodo.setText("");
                }
                else{
                    Toast.makeText(GroceriesActivity.this, "Error in storing data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
