package com.example.my_application;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void login(View v) {
        Intent i = new Intent(this, homeActivity.class);

        TextView t = findViewById(R.id.username);
        String name = t.getText().toString();

        i.putExtra("uname", name);

        TextView p = findViewById(R.id.password);
        String password = p.getText().toString();

        if(TextUtils.isEmpty(password)){
            p.setError("EMPTY PASSWORD");
        }
        if(TextUtils.isEmpty(name)){
            t.setError("EMPTY USERNAME");
        }
        if(password.equals("lepassword")) {
            startActivity(i);
        }
        else{
            Toast.makeText(this, "ERROR: PASSWORD INCORRECT", Toast.LENGTH_SHORT).show();

        }
    }

}