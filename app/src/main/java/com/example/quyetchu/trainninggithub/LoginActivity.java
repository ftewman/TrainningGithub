package com.example.quyetchu.trainninggithub;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    CheckBox cbRememberMe;
    EditText edtUsername;
    EditText edtPassword;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USERNAME_KEY = "username";
    String PASSWORD_KEY = "password";
    String REMEMBER_KEY = "remember";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);

        edtUsername.setText(sharedPreferences.getString(USERNAME_KEY, ""));
        edtPassword.setText(sharedPreferences.getString(PASSWORD_KEY, ""));
        cbRememberMe.setChecked(sharedPreferences.getBoolean(REMEMBER_KEY, false));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString();
                editor = sharedPreferences.edit();

                if(cbRememberMe.isChecked()){
                    editor.putString(USERNAME_KEY, username);
                    editor.putString(PASSWORD_KEY, password);
                    editor.putBoolean(REMEMBER_KEY, true);

                }else {
                    editor.clear();

                }
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }

    private void init(){
        cbRememberMe = (CheckBox) findViewById(R.id.cbRememberMe);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtUsername = (EditText) findViewById(R.id.edtUserName);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }
}
