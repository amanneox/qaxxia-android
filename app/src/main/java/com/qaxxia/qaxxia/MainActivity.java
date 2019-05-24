package com.qaxxia.qaxxia;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.qaxxia.qaxxia.Fragments.FavoriteFragment;
import com.qaxxia.qaxxia.Fragments.HomeFragment;
import com.qaxxia.qaxxia.Fragments.HotFragment;
import com.qaxxia.qaxxia.Fragments.OrdersFragment;
import com.qaxxia.qaxxia.Fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = (BottomNavigationView)findViewById(R.id.bottomnav);
        navigationView.setOnNavigationItemSelectedListener(NavItemSelected);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        loadFragment(new HomeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener NavItemSelected
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.item_1:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.item_2:
                    fragment = new HotFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.item_3:
                    fragment = new OrdersFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.item_4:
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.item_5:
                    fragment = new FavoriteFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
