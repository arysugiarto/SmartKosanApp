package com.mppl.smartkosanapp.Activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mppl.smartkosanapp.Fragment.HistoriFragment;
import com.mppl.smartkosanapp.Fragment.HomeFragment;
import com.mppl.smartkosanapp.Fragment.KamarFragment;
import com.mppl.smartkosanapp.Fragment.ProfileFragment;
import com.mppl.smartkosanapp.Fragment.TagihanFragment;
import com.mppl.smartkosanapp.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            loadFragment(new HomeFragment());
            BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
            bottomNavigationView.setOnNavigationItemSelectedListener(this);
        }



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment = null;
            switch (menuItem.getItemId()){
                case R.id.home_menu:
                    fragment = new HomeFragment();
                    break;
                case R.id.tagihan:
                    fragment = new TagihanFragment();
                    break;
                case R.id.kamar:
                    fragment = new KamarFragment();
                    break;
                case R.id.history:
                    fragment = new HistoriFragment();
                    break;
                case R.id.akun:
                    fragment = new ProfileFragment();
                    break;
            }
            return loadFragment(fragment);
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}
