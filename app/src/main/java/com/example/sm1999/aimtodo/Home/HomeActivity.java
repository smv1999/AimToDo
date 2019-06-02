package com.example.sm1999.aimtodo.Home;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sm1999.aimtodo.FamilyActivity;
import com.example.sm1999.aimtodo.GroceriesActivity;
import com.example.sm1999.aimtodo.MoviesToWatchActivity;
import com.example.sm1999.aimtodo.MusicActivity;
import com.example.sm1999.aimtodo.PrivateActivity;
import com.example.sm1999.aimtodo.R;
import com.example.sm1999.aimtodo.StudiesActivity;
import com.example.sm1999.aimtodo.TravelActivity;
import com.example.sm1999.aimtodo.Utils.DatabaseHelper;
import com.example.sm1999.aimtodo.WorkActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        databaseHelper = new DatabaseHelper(this);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity

            startActivity(new Intent(HomeActivity.this, SplashscreenActivity.class));
        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply(); //commit()


        final ArrayList<String> tasksArray = new ArrayList<>();
        tasksArray.add("Travel");
        tasksArray.add("Groceries");
        tasksArray.add("Movies To Watch");
        tasksArray.add("Work");
        tasksArray.add("Family");
        tasksArray.add("Private");
        tasksArray.add("Studies");
        tasksArray.add("Music");



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(HomeActivity.this);
                builderSingle.setTitle("Select One Name:-");

                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(HomeActivity.this, android.R.layout.select_dialog_singlechoice,tasksArray);

                builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = arrayAdapter.getItem(which);
                        if(strName.equals("Travel")){
                            Intent i = new Intent(HomeActivity.this,TravelActivity.class);
                            startActivity(i);
                        }
                        if(strName.equals("Groceries")){
                            Intent i = new Intent(HomeActivity.this,GroceriesActivity.class);
                            startActivity(i);
                        }
                        if(strName.equals("Movies To Watch")){
                            Intent i = new Intent(HomeActivity.this,MoviesToWatchActivity.class);
                            startActivity(i);
                        }
                        if(strName.equals("Work")){
                            Intent i = new Intent(HomeActivity.this,WorkActivity.class);
                            startActivity(i);
                        }
                        if(strName.equals("Family")){
                            Intent i = new Intent(HomeActivity.this,FamilyActivity.class);
                            startActivity(i);
                        }
                        if(strName.equals("Private")){
                            Intent i = new Intent(HomeActivity.this,PrivateActivity.class);
                            startActivity(i);
                        }
                        if(strName.equals("Studies")){
                            Intent i = new Intent(HomeActivity.this,StudiesActivity.class);
                            startActivity(i);
                        }if(strName.equals("Music")){
                            Intent i = new Intent(HomeActivity.this,MusicActivity.class);
                            startActivity(i);
                        }

                    }
                });
                builderSingle.show();


            }
        });

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, tasksArray);

        final ListView listView = (ListView) findViewById(R.id.todolist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                String str=(String)o;//As you are using Default String Adapter
                if(str.equals("Travel")){
                    Intent i = new Intent(HomeActivity.this,TravelActivity.class);
                    startActivity(i);
                }
                if(str.equals("Groceries")){
                    Intent i = new Intent(HomeActivity.this,GroceriesActivity.class);
                    startActivity(i);
                }
                if(str.equals("Movies To Watch")){
                    Intent i = new Intent(HomeActivity.this,MoviesToWatchActivity.class);
                    startActivity(i);
                }
                if(str.equals("Work")){
                    Intent i = new Intent(HomeActivity.this,WorkActivity.class);
                    startActivity(i);
                }
                if(str.equals("Family")){
                    Intent i = new Intent(HomeActivity.this,FamilyActivity.class);
                    startActivity(i);
                }
                if(str.equals("Private")){
                    Intent i = new Intent(HomeActivity.this,PrivateActivity.class);
                    startActivity(i);
                }
                if(str.equals("Studies")){
                    Intent i = new Intent(HomeActivity.this,StudiesActivity.class);
                    startActivity(i);
                }if(str.equals("Music")){
                    Intent i = new Intent(HomeActivity.this,MusicActivity.class);
                    startActivity(i);
                }

            }
        });


    }
    public void display(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      switch (item.getItemId()){
          case R.id.exitid:
//              this.finish();
              finishAffinity();
              break;
          case R.id.delete:
              final AlertDialog.Builder builderSingle = new AlertDialog.Builder(HomeActivity.this);
              final EditText input = new EditText(HomeActivity.this);
              builderSingle.setCancelable(false);
              builderSingle.setTitle("Enter the ID:");
              builderSingle.setView(input);
              builderSingle.setPositiveButton("okay", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      int temp = input.getText().toString().length();
                      if(temp > 0){
                          Integer deleteRow = databaseHelper.deleteData(input.getText().toString());
                          if(deleteRow > 0){
                              Toast.makeText(HomeActivity.this, "Successfully Deleted The to-do!", Toast.LENGTH_LONG).show();
                          }else{
                              Toast.makeText(HomeActivity.this, "That ID doesn't exist:(.", Toast.LENGTH_LONG).show();
                          }
                      }
                      else{
                          Toast.makeText(HomeActivity.this, "You Must Enter An ID to Delete :(.", Toast.LENGTH_LONG).show();
                      }




                  }
              });
              builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dialog.dismiss();
                  }
              });
              builderSingle.show();
              break;
          case R.id.update:
              final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
              LinearLayout layout = new LinearLayout(this);
              layout.setOrientation(LinearLayout.VERTICAL);

              final EditText id = new EditText(this);
              id.setHint("ID");
              layout.addView(id); // Notice this is an add method

              final EditText travel = new EditText(this);
              travel.setHint("Travel");
              layout.addView(travel); // Another add method

              final EditText groceries = new EditText(this);
              groceries.setHint("Groceries");
              layout.addView(groceries);

              final EditText movies = new EditText(this);
              movies.setHint("Movies To Watch");
              layout.addView(movies);

              final EditText work = new EditText(this);
              work.setHint("Work");
              layout.addView(work);

              final EditText family = new EditText(this);
              family.setHint("Travel");
              layout.addView(family);

              final EditText Private = new EditText(this);
              Private.setHint("Private");
              layout.addView(Private);

              final EditText studies = new EditText(this);
              studies.setHint("Studies");
              layout.addView(studies);

              final EditText music = new EditText(this);
              music.setHint("Music");
              layout.addView(music);

              builder.setView(layout);
              builder.setCancelable(false);
              builder.setTitle("Enter Data:");
              builder.setPositiveButton("okay", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {

                      int temp = id.getText().toString().length();
                      if (temp > 0) {
                          boolean update = databaseHelper.updateData(id.getText().toString(), travel.getText().toString(),
                                  groceries.getText().toString(), movies.getText().toString(),work.getText().toString(),family.getText().toString(),Private.getText().toString()
                                  ,studies.getText().toString(),music.getText().toString());
                          if (update == true) {
                              Toast.makeText(HomeActivity.this, "Successfully Updated to-do!", Toast.LENGTH_LONG).show();
                          } else {
                              Toast.makeText(HomeActivity.this, "Something Went Wrong :(.", Toast.LENGTH_LONG).show();
                          }
                      } else {
                          Toast.makeText(HomeActivity.this, "You Must Enter An ID to Update :(.", Toast.LENGTH_LONG).show();
                      }



                  }
              });
              builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dialog.dismiss();
                  }
              });
              builder.show();
              break;

          case R.id.about:
              Intent i = new Intent(HomeActivity.this,AboutActivity.class);
              startActivity(i);
              break;
          case R.id.showtodo:

              Cursor data = databaseHelper.showData("TRAVEL");
              if(data.getCount()==0){
                  display("Message","No Data Found!");
              }
              StringBuffer buffer = new StringBuffer();
              while(data.moveToNext()){
                  buffer.append("ID: "+data.getString(0)+"\n");
                  buffer.append("TRAVEL: " + data.getString(1)+"\n");
                  buffer.append("GROCERIES: "+data.getString(2)+"\n");
                  buffer.append("MOVIES: "+data.getString(3)+"\n");
                  buffer.append("WORK: "+data.getString(4)+"\n");
                  buffer.append("FAMILY: "+data.getString(5)+"\n");
                  buffer.append("PRIVATE: "+data.getString(6)+"\n");
                  buffer.append("STUDIES: "+data.getString(7)+"\n");
                  buffer.append("MUSIC: "+data.getString(8)+"\n");


              }
              display("All Stored to-dos",buffer.toString());
          default:
              return super.onOptionsItemSelected(item);


      }
        return false;
    }
}
