package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        //Name.setText(lowerCaseString);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)(findViewById(R.id.btnLogin));

        Info.setText("No. of attempts left : " + String.valueOf(Counter));

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate(Name.getText().toString(), Password.getText().toString());

            }
        });

    }

    protected void validate(String username, String password){

        if(username.equals("SHISHIR") && password.equals("Senpai@420")){
            startActivity( new Intent(MainActivity.this, SecondActivity.class));
        }
        else{
            Counter--;

            Info.setText("No. of attempts left : " + String.valueOf(Counter));

            if(Counter == 0){
                Login.setEnabled(false);
                Info.setText("You have exceeded limit, Try again later.");
            }
        }

    }
}