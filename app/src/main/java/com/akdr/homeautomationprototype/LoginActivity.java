package com.akdr.homeautomationprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth Auth = FirebaseAuth.getInstance();

    private String M, P;

    private TextView txtvw;
    private EditText Mail, Pass;

    private Button Login_BTN, Su;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Mail = (EditText) findViewById(R.id.mail_data);
        Pass = (EditText) findViewById(R.id.pass_data);

        txtvw = findViewById(R.id.signup_btn);

        Login_BTN = (Button) findViewById(R.id.Login_BTN);
        Su = (Button) findViewById(R.id.SU_BTN);

        Login_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LOG();
            }
        });

        Su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });

    }


    private void LOG(){

        M = Mail.getText().toString().trim();
        P = Pass.getText().toString().trim();

        if(M.isEmpty() && P.isEmpty()){
            Mail.setError("Required");
            Pass.setError("Required");
        }
        else{
            Auth.signInWithEmailAndPassword(M, P).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isComplete()){
                        Toast.makeText(LoginActivity.this, "\nLogged in Successfully!\n", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "\nError Logging in!\n", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }

    private  void SignupFunc(){
        startActivity(new Intent(LoginActivity.this, SignupActivity.class));
        finish();
    }

}