package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGuess;
    EditText etNum;
    TextView tvResult, tvCounter, tvBull, tvCows, tvShow;
    String hiddenNum;
    boolean game_over = false;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuess = findViewById(R.id.btnGuess);
        btnGuess.setOnClickListener(this);
        etNum = findViewById(R.id.etNum);
        btnGuess.setOnClickListener(this);
        tvResult = findViewById(R.id.tvInfo);
        tvCounter = findViewById(R.id.tvCounter);
        tvCows = findViewById(R.id.tvCow);
        tvBull = findViewById(R.id.tvBull);
        hiddenNum = generateNum();
        tvShow = findViewById(R.id.tvShow);
        tvShow.setText("Ответ: " + hiddenNum);
    }

    @Override
    public void onClick(View v) {
        String user_inp;
        int bulls_count;
        int cows_count;
        switch (v.getId()){
            case R.id.btnGuess:
                if(!game_over){
                    user_inp = etNum.getText().toString();
                    counter++;
                    if(user_inp.equals(hiddenNum)){
                        tvResult.setText("Ты угадал!");
                        tvBull.setText("Быков: 4");
                        tvCows.setText("Коров: 0");
                        btnGuess.setText("Начать заново!");
                        game_over = true;
                    }else{
                        bulls_count = countBulls(hiddenNum, user_inp);
                        cows_count = countCows(hiddenNum, user_inp);
                        tvResult.setText("Попробуй ещё!");
                        tvBull.setText("Быков: " + bulls_count);
                        tvCows.setText("Коров: " + cows_count);
                    }
                    tvCounter.setText("Ходов сделано: " + counter);
                }else{
                    hiddenNum = generateNum();
                    tvShow.setText("Ответ: " + hiddenNum);
                    tvResult.setText("Я загадал число!");
                    tvBull.setText("Быков:");
                    tvCows.setText("Коров:");
                    btnGuess.setText("Угадать");
                    counter = 0;
                    tvCounter.setText("Ходов сделано: " + counter);
                    game_over = false;
                }
                break;
            default:
                break;
        }

    }

    public String generateNum(){
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        String result = "";
        int i = 0;
        while(result.length() != 4){
            if (numbers.get(i) != 0) {
                result += numbers.get(i).toString();
            }
            i++;
        }
        return result;
    }

    public int countBulls(String num, String guess){
        int counter = 0;
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == guess.charAt(i)){
                counter ++;
            }
        }
        return counter;
    }

    public int countCows(String num, String guess){
        int counter = 0;
        for(int i = 0; i < num.length(); i++){
            for(int j = 0; j < num.length(); j++){
                if((num.charAt(i) == guess.charAt(j)) && (i != j)){
                    counter ++;
                }
            }
        }
        return counter;
    }


}