package com.example.flagme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferenceConfig preferenceConfig;
    private EditText UserName,UserPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        UserName = findViewById(R.id.user_name);
        UserPassword = findViewById(R.id.user_password);

        // check if the user is already login
        if(preferenceConfig.readLoginStatus()){

            startActivity(new Intent(this, FlagActivity.class));
            finish();

        }

    }

    public void LOGIN(View view) {

        String username = UserName.getText().toString();
        String userpassword = UserPassword.getText().toString();


        if (username.equals(getResources().getString(R.string.user_name)) && userpassword.equals(getResources().getString(R.string.user_password))) {

            startActivity(new Intent(this, FlagActivity.class));
            finish();
            // save login preference if login successfully
            preferenceConfig.writeLoginStatus(true);

        }
        else {

            Toast.makeText(this,"Unknown user or incorrect password.", Toast.LENGTH_SHORT).show();
            // reset user name and password if fail
            UserName.setText("");
            UserPassword.setText("");
        }


    }
}
