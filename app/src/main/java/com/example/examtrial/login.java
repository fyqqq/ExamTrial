package com.example.examtrial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText username, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.txtName);
        password = findViewById(R.id.txtPass);
        loginBtn = findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                {
                    Toast.makeText(login.this,
                            "Please input all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(user.equals("admin") && pass.equals("123"))
                    {

                        Toast.makeText(login.this,
                                "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intentLogin = new Intent(getApplicationContext(),MainActivity.class);
                        intentLogin.putExtra("username",user);
                        startActivity(intentLogin);
                    }
                    else
                    {
                        showAlert();
                    }
                }
            }
        });

    }

    public void showAlert() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Authentication Error");
        builder.setMessage("Wrong username and password, please try again!");
        // add a button
        builder.setPositiveButton("OK", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}