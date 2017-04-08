package com.example.mobileappdevelop.simpledoctor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText logInEmailTV;
    private EditText logInPassTV;
    private TextView forgetPassTv;
    private Button signInBtn;
    LogInPref logInPref;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
sharedPreferences=getSharedPreferences(RegSharePreference.REG_SHARE_PREFERENCE_NAME,MODE_PRIVATE);
        logInPref=new LogInPref(sharedPreferences);
        logInEmailTV = (EditText) findViewById(R.id.logInEmail);
        logInPassTV = (EditText) findViewById(R.id.logInPass);
        forgetPassTv = (TextView) findViewById(R.id.forgatePass);
        signInBtn = (Button) findViewById(R.id.signIn);

        forgetPassTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "sad", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(v.getContext(),
                        RecoveryPassword.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });

    }

    public void signIn(View view) {


        String userEmai = logInEmailTV.getText().toString();
        String userPass = logInPassTV.getText().toString();
        boolean login = logInPref.LogIn(userEmai,userPass);
        if (login){
            Intent myIntent = new Intent(view.getContext(),
                    DoctorsList.class);
            startActivityForResult(myIntent, 0);
            finish();
        }
        else {
            Toast.makeText(this,"Email or password is incorrect",Toast.LENGTH_SHORT).show();
        }


    }
}
