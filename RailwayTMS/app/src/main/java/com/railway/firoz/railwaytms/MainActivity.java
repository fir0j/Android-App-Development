package com.railway.firoz.railwaytms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView mLoginCV;
    private EditText musernameField;
    private EditText mpasswordField;
    private String musername_input;
    private String mpassword_input;


    public void loggedIn(){
        musername_input = musernameField.getText().toString().trim();
        mpassword_input = mpasswordField.getText().toString().trim();

        if(musername_input.equalsIgnoreCase("MiniProject") && mpassword_input.equalsIgnoreCase("l")){
            Intent intent = new Intent(this,loggedin_Activity2.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),R.string.wrongPasswordAlert,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginCV = (CardView)findViewById(R.id.loginCV);
        musernameField = (EditText)findViewById(R.id.username);
        mpasswordField = (EditText)findViewById(R.id.password);


            mLoginCV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loggedIn();
                }
            });
    }
}

