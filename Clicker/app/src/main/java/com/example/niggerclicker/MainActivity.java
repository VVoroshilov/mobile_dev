package com.example.niggerclicker;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    TextView mainText;
    ImageButton mainBtnUp;
    ImageButton mainBtnDown;
    Button mainBtnOff;
    long num=0;
    private long score = 0;
    View.OnClickListener clickListenerUp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score++;
            String s = "Times switched: " + score;
            mainText.setText(s.toCharArray(), 0, s.length());
            LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutID);
            mLinearLayout.setBackgroundResource(R.drawable.on);
        }
    };

    View.OnClickListener clickListenerDown = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score--;
            String s = "Times switched: " + score;
            mainText.setText(s.toCharArray(), 0, s.length());
            LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutID);
            mLinearLayout.setBackgroundResource(R.drawable.off);
        }
    };

    View.OnClickListener clickListenerNull = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score = 0;
            String s = "Times switched: " + score;
            mainText.setText(s.toCharArray(), 0, s.length());
            LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutID);
            mLinearLayout.setBackgroundResource(R.drawable.off);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = (TextView) findViewById(R.id.mainTxt);
        mainBtnUp = (ImageButton) findViewById(R.id.main_btnUp);
        mainBtnUp.setOnClickListener(clickListenerUp);
        mainBtnDown = (ImageButton) findViewById(R.id.main_btnDown);
        mainBtnDown.setOnClickListener(clickListenerDown);
        mainBtnOff = (Button) findViewById(R.id.main_btnNull);
        mainBtnOff.setOnClickListener(clickListenerNull);
    }
}