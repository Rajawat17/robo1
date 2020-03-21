package com.example.robo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button go;
    private TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.etname);
        password=(EditText)findViewById(R.id.etpassword);
        go=(Button)findViewById(R.id.btnlogin);
        signup=(TextView)findViewById(R.id.tvsignup);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,register.class));
            }
        });

    }
    private void validate(String username,String userpassword){
        if(username.equals("Admin") && userpassword.equals("1234")){
            startActivity(new Intent(MainActivity.this,home.class));
        }
    }
}
