package com.example.tikcock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
    TextView mainTextView;
    Button mainButton, ok_btn, cnc_btn;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    @Override
    public void onClick(View v){
        mainTextView.setText(mainEditText.getText().toString() + " sent");
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id ) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText("You tapped on " + mNameList.get(position).toString() );
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.main_textview);
        mainTextView.setText("Welcome");
        mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        mainEditText = (EditText) findViewById(R.id.main_edittext);
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);
        mainListView.setOnItemClickListener(this);
        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);
        View.OnClickListener oclBtn = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch(view.getId()){
                    case R.id.ok_btn:
                        mainTextView.setText("First button pressed");
                        Toast.makeText(getApplicationContext(), "First button pressed",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cnc_btn:
                        mainTextView.setText("Second button pressed");
                        Toast.makeText(getApplicationContext(), "Second button pressed",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        ok_btn.setOnClickListener(oclBtn);
        cnc_btn.setOnClickListener(oclBtn);
    }
}