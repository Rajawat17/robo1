package com.example.robo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    private EditText username, userpassword, useremail;
    private Button regbutton;
    private TextView userlogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupviews();
        firebaseAuth=FirebaseAuth.getInstance();
        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                if(validate()){
                    //upload data to database
                    String user_email=useremail.getText().toString().trim();
                    String user_password=userpassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(register.this,"registration successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this,MainActivity.class));
                            }
                           else{
                                Toast.makeText(register.this,"registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this,MainActivity.class));
            }
        });
    }
     private void setupviews(){
        username=(EditText)findViewById(R.id.etname);
         userpassword=(EditText)findViewById(R.id.etpassword);
         useremail=(EditText)findViewById(R.id.etemail);
         userlogin=(TextView)findViewById(R.id.tvlogin);
     }
     private Boolean validate(){
        Boolean result =false;
        String name =username.getText().toString();
         String password =userpassword.getText().toString();
         String email =useremail.getText().toString();
         if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
             Toast.makeText(this,"please enter all details",Toast.LENGTH_SHORT).show();
         }
         else{
             result=true;
         }
         return result;
     }
}
