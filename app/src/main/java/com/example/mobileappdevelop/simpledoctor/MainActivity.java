package com.example.mobileappdevelop.simpledoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView isMemberTv;
    private Button newMemberTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        isMemberTv = (TextView) this.findViewById(R.id.isMember);
        newMemberTv = (Button) this.findViewById(R.id.newMember);

        isMemberTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "sad", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(v.getContext(),
                        Login.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });

        newMemberTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),
                        Register.class);
                startActivityForResult(myIntent, 0);
                finish();
                //Toast.makeText(MainActivity.this, "sad", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
