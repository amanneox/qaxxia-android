package com.qaxxia.qaxxia;

import android.app.ActionBar;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = (BottomNavigationView)findViewById(R.id.bottomnav);
        navigationView.setOnNavigationItemSelectedListener(NavItemSelected);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener NavItemSelected
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            //Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.item_1:
                    return true;
                case R.id.item_2:
                    return true;
                case R.id.item_3:
                    return true;
                case R.id.item_4:
                    return true;
                case R.id.item_5:
                    return true;
            }
            return false;
        }
    };
}
