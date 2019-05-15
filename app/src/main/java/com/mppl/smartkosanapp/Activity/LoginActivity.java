package com.mppl.smartkosanapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mppl.smartkosanapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button btnMoveActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnMoveActivity = findViewById(R.id.buttonsignin);
        btnMoveActivity.setOnClickListener(this);
    }

@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonsignin:
                Intent moveIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(moveIntent);
                break;
        }
    }
}
