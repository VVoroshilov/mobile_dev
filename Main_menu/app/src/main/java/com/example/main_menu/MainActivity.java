package com.example.main_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        checkBox = (CheckBox) findViewById(R.id.chbExtMenu);
    }

//    public boolean onCreateOptionsMenu(Menu menu){
//        menu.add(0, 1, 0, "Пункт 1");
//        menu.add(0, 2, 1, "Пункт 2");
//        menu.add(0, 3, 2, "Пункт 3");
//        menu.add(1, 4, 3, "Пункт 4");
//        menu.add(1, 5, 4, "Пункт 5");
//        menu.add(1, 6, 5, "Пункт 6");
//
//        return super.onCreateOptionsMenu(menu);
//    }

//    public boolean onPrepareOptionsMenu(Menu menu) {
//        menu.setGroupVisible(1, checkBox.isChecked());
//        return super.onPrepareOptionsMenu(menu);
//    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.group1, checkBox.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Item Menu");
        stringBuilder.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        stringBuilder.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        stringBuilder.append("\r\n order: " + String.valueOf(item.getOrder()));
        stringBuilder.append("\r\n title: " + item.getTitle());
        textView.setText(stringBuilder.toString());

        return super.onOptionsItemSelected(item);
    }
}