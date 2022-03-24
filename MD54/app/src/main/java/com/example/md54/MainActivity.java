package com.example.md54;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button toastBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toastBtn = findViewById(R.id.toastbtn);

        final Button btnStart = findViewById(R.id.button_start);
        final Button btnStop = findViewById(R.id.button_stop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// используем явный вызов службы
                startService(
                        new Intent(MainActivity.this, PlayService.class));
            };
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(
                        new Intent(MainActivity.this, PlayService.class));
            };
        });

        toastBtn.setOnClickListener(this);
    };
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toastbtn:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Текстовое сообщение", Toast.LENGTH_SHORT);
                toast.show();
                break;
            default:
                break;
        };
    }
}