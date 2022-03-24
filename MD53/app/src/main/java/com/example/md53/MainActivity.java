package com.example.md53;

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
    Button ok_btn, cnc_btn;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    @Override
    public void onClick(View v){
        mArrayAdapter.notifyDataSetChanged();

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id ) {
        Log.d("omg android", position + ": " + mNameList.get(position));
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                mNameList);
        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);
        View.OnClickListener oclBtn = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch(view.getId()){
                    case R.id.ok_btn:
                        Toast.makeText(getApplicationContext(), "First button pressed",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cnc_btn:
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