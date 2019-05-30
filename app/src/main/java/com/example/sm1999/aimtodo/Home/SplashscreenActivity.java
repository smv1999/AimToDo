package com.example.sm1999.aimtodo.Home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sm1999.aimtodo.R;
import com.example.sm1999.aimtodo.Utils.CustomPagerAdapter;

public class SplashscreenActivity extends AppCompatActivity {


    Button nextbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

            ViewPager mViewPager;
            mViewPager =  findViewById(R.id.pager);

// This is just an example. You can use whatever collection of images.
        int[] mResources = {
                R.drawable.todolistimage,
                R.drawable.menutodo,
                R.drawable.maintodo

        };

        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this, mResources);

        mViewPager.setAdapter(mCustomPagerAdapter);

        nextbutton = findViewById(R.id.nextButton);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashscreenActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
