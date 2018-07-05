package com.example.dsm2018.viewpagerpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button loginLoginButton;
    private EditText loginIdEdit, loginPwEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginLoginButton = (Button) findViewById(R.id.button_login_login);
        loginIdEdit = (EditText) findViewById(R.id.edit_login_id);
        loginPwEdit = (EditText) findViewById(R.id.edit_login_pw);
    }
}
