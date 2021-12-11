package com.example.md31;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSave;
    EditText etName;
    TextView getInfo;
    Spinner getSpinner;
    private Button btnDatePicker;
    private EditText editTextDate;
    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        etName = (EditText)findViewById(R.id.etName);
        getInfo = (TextView)findViewById(R.id.getInfo);
        getSpinner = findViewById(R.id.spinner);
        btnSave.setOnClickListener(this);






        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        getSpinner.setAdapter(adapter);
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView textView = findViewById(R.id.seekBarValue);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnDatePicker = (Button) findViewById(R.id.btn_date);
        editTextDate = (EditText) findViewById(R.id.picked_date);
        btnDatePicker.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name = "";
        switch (v.getId()){
            case R.id.btn_date:
                callDatePicker();
                break;
            case R.id.btnSave:

                String result = etName.getText().toString();
                String result_date = editTextDate.getText().toString();
                TextView textView = findViewById(R.id.seekBarValue);
                SharedPreferences.Editor ed = getPreferences(MODE_PRIVATE).edit();

                name =  "Имя: " + result + "\nВозраст: " + textView.getText().toString() + "\nГруппа: " +getSpinner.getSelectedItem().toString()+ "\nДень рождения: "+ result_date;

                ed.putString("name", name);
                ed.commit();
                Log.i("SPREF", name);

                SharedPreferences pref = getPreferences(MODE_PRIVATE);
                name = pref.getString("name", "");
                getInfo.setText(name);
                break;


            default:
                break;
        }
    }
    private void callDatePicker() {

        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        editTextDate.setText(editTextDateParam);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}