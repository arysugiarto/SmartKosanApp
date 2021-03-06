package com.mppl.smartkosanapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.mppl.smartkosanapp.Fragment.HistoriFragment;
import com.mppl.smartkosanapp.Fragment.HomeFragment;
import com.mppl.smartkosanapp.Fragment.KamarFragment;
import com.mppl.smartkosanapp.Fragment.ProfileFragment;
import com.mppl.smartkosanapp.Fragment.TagihanFragment;
import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.SessionManager;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    SessionManager sessionManager;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);

        btnLogout = findViewById(R.id.Logout);

        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
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



//
//    @OnClick(R.id.Logout)
//    public void btnLogout(){
//        sessionManager = new SessionManager(MainActivity.this);
//        sessionManager.logout();
//        finish();
//    }

    public void onClick(View v) {
        FirebaseAuth.getInstance().signOut();
        if (v.getId() == R.id.Logout) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            // user is now signed out
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            finish();
                        }
                    });
        }
    }

    public void card(View view) {
        if (view.getId()==R.id.kamar){
            Intent intent = new Intent(MainActivity.this, TagihanActivity.class);
            startActivity(intent);
        }else if (view.getId()==R.id.inet){
            Intent intent = new Intent(MainActivity.this, TagihanActivity.class);
            startActivity(intent);
        }

    }
}
