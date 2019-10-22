package com.example.flagme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FlagActivity extends AppCompatActivity {

    private SharedPreferenceConfig preferenceConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
    }

    public void LOGOUT(View view) {

        preferenceConfig.writeLoginStatus(false);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
