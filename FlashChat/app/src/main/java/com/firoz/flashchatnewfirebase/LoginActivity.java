package com.firoz.flashchatnewfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    // TODO: Add member variables here:
    private FirebaseAuth mauth;
    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.firoz.flashchatnewfirebase.R.layout.activity_login);

        mEmailView = (AutoCompleteTextView) findViewById(com.firoz.flashchatnewfirebase.R.id.login_email);
        mPasswordView = (EditText) findViewById(com.firoz.flashchatnewfirebase.R.id.login_password);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == com.firoz.flashchatnewfirebase.R.integer.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        // TODO: Grab an instance of FirebaseAuth
        mauth = FirebaseAuth.getInstance();

    }

    // Executed when Sign in button pressed
    public void signInExistingUser(View v)   {
        // TODO: Call attemptLogin() here
        attemptLogin();

    }

    // Executed when Register button pressed
    public void registerNewUser(View v) {
        Intent intent = new Intent(LoginActivity.this, com.firoz.flashchatnewfirebase.RegisterActivity.class);
        finish();
        startActivity(intent);
    }

    // TODO: Complete the attemptLogin() method
    private void attemptLogin() {

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        if(email.equals("") || password.equals("")) return;
        Toast.makeText(this.getApplicationContext(), "Login in Progress", Toast.LENGTH_SHORT).show();

        // TODO: Use FirebaseAuth to sign in with email & password
        mauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            Toast.makeText(getApplicationContext(), "signONcomplete():" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                if(!task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Problem signing in:" + task.getException(), Toast.LENGTH_SHORT).show();
                    showErrorDialog("There was problem signing in");
                }else {
                Intent i = new Intent(LoginActivity.this, MainChatActivity.class);
                finish();
                startActivity(i);

                }
            }
        });

    }

    // TODO: Show error on screen with an alert dialog
    public void showErrorDialog(String Message) {
        //this is alternative method of creating alert dialog other than in documentation
        new AlertDialog.Builder(this)
                .setTitle("Opps!")
                .setMessage(Message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


}