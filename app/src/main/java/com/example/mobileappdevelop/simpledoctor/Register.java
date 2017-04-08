package com.example.mobileappdevelop.simpledoctor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText regFnameTV;
    private EditText regLnameTV;
    private EditText regEmailTV;
    private EditText regPassTV;
    private EditText regConPassTV;
    private EditText regSecurityAnsTV;
    private Spinner securityQusSpinner;
    private String selectedSecurityQus;
    SharedPreferences sharePreference;
    RegSharePreference regSharePreference;
    RegisterPref aRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sharePreference=getSharedPreferences(RegSharePreference.REG_SHARE_PREFERENCE_NAME,MODE_PRIVATE);
        regSharePreference=new RegSharePreference(sharePreference);

        aRegister=new RegisterPref();
        regFnameTV = (EditText) findViewById(R.id.regFname);
        regLnameTV = (EditText) findViewById(R.id.regLname);
        regEmailTV = (EditText) findViewById(R.id.regEmail);
        regPassTV = (EditText) findViewById(R.id.regPass);
        regConPassTV = (EditText) findViewById(R.id.regConPass);
        regSecurityAnsTV = (EditText) findViewById(R.id.regSecurityAns);
        securityQusSpinner = (Spinner) findViewById(R.id.regSecurityQus);


        securityQusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedSecurityQus = securityQusSpinner.getSelectedItem().toString();
                //Toast.makeText(MainActivity.this, citySpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void signUp(View view) {
        aRegister.setFirstName(regFnameTV.getText().toString());
        aRegister.setLastName(regLnameTV.getText().toString());
        aRegister.setEmail(regEmailTV.getText().toString());
        aRegister.setPasword(regPassTV.getText().toString());
       aRegister.setSecQues(selectedSecurityQus);
        aRegister.setSecQuesAns(selectedSecurityQus);
        String conPass = regConPassTV.getText().toString();
        if (aRegister.getPasword().equals(conPass)){
            regSharePreference.Save(aRegister);
            Toast.makeText(this, "Successfully register "+aRegister.getFirstName(), Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(view.getContext(),
                    Login.class);
            startActivityForResult(myIntent, 0);
            finish();
        }
        else{
            Toast.makeText(this,"Password doesn't match", Toast.LENGTH_SHORT).show();
        }
    }
}
