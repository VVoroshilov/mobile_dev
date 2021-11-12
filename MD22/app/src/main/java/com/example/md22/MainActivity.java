package com.example.md22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button switchButtonTime;
    Button switchButtonDate;
    Button inputNameButton;
    EditText editText;
    String name;
    TextView tvName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchButtonTime = (Button) findViewById(R.id.btnTime);
        switchButtonTime.setOnClickListener(this);

        switchButtonDate = (Button) findViewById(R.id.btnDate);
        switchButtonDate.setOnClickListener(this);

        inputNameButton = (Button) findViewById(R.id.btnName);
        inputNameButton.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.etLName);
        name = editText.getText().toString();

        tvName = (TextView) findViewById(R.id.tvName);
    }

    public void onClick(View v) {
        Intent intent;

        switch(v.getId()) {
            case R.id.btnTime:
                intent = new Intent("com.example.intent.action.showtime");
                intent.putExtra("lname", editText.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent("com.example.intent.action.showdate");
                intent.putExtra("lname", editText.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnName:
                intent = new Intent(this, NameActivity.class);
                startActivityForResult(intent, 1);
                break;

        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            String name = data.getStringExtra("name");
            tvName.setText("Your name is " + name);
        }
    }


}