package com.example.randomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Button exitBtn;
    int number;
    boolean isend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View.OnClickListener clickListenerExit = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
                System.exit(0);
            }
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView2);
        etInput=(EditText)findViewById(R.id.editTextNumber2);
        bControl=(Button)findViewById(R.id.button2);
        exitBtn = (Button) findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(clickListenerExit);
        number = (int)(Math.random()*101);
        isend = false;
    }

    public void onClick(View v){
        int input = -1;
        try {
             input = Integer.parseInt(etInput.getText().toString());
        }catch (Exception e){
            tvInfo.setText(getResources().getString(R.string.error));
        }

        if(input > number && input<100 && input>0) {
            tvInfo.setText(getResources().getString(R.string.behind));
        }

        if(input < number && input<100 && input>0) {
            tvInfo.setText(getResources().getString(R.string.ahead));
        }

        if(input == number && input<100 && input>0) {
            tvInfo.setText(getResources().getString(R.string.hit));
            isend = true;
        }

        if(input>100 || input<0) {
            tvInfo.setText(getResources().getString(R.string.error));
        }

        if (isend){
            number = (int)(Math.random()*101);
            isend = false;
            bControl.setText(getResources().getString(R.string.play_more));
        }

    }
};
