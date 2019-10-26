package com.example.flagme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class FlagActivity extends AppCompatActivity {

    private SharedPreferenceConfig preferenceConfig;
    private android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        setSupportActionBar(toolbar);
    }

    public void LOGOUT(View view) {

        preferenceConfig.writeLoginStatus(false);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
