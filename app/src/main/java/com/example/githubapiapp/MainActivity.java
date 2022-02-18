package com.example.githubapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText user;
    AppCompatButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        search = findViewById(R.id.search);

        onSearch();
    }

    private void onSearch() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserDetails.class);
                intent.putExtra("userLogin",user.getText().toString());
                startActivity(intent);
            }
        });
    }
}