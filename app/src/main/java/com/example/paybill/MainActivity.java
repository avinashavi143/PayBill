package com.example.paybill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button payBill;
    private TextView TipPercentage;
    private EditText enterAmount;
    private SeekBar seekbar;
    private TextView totalResultTestView;
    int seekBarProgress;
    float enteredAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmount = (EditText) findViewById(R.id.EnterAmount);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        payBill = (Button) findViewById(R.id.button);
        TipPercentage = (TextView) findViewById(R.id.textView);
        totalResultTestView = (TextView) findViewById(R.id.result);

        payBill.setOnClickListener(this::onClick);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TipPercentage.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarProgress = seekBar.getProgress();
                Log.d("SeekBar", "Seek Bar progress is"+seekBarProgress);
            }
        });
    }

    public void onClick(View v) {
        caliculate();
    }

    public void caliculate() {
        float result = 0.0f;
        if(!enterAmount.getText().toString().equals("")) {
            enteredAmount = Float.parseFloat(enterAmount.getText().toString());
            result = (( enteredAmount / 100) * seekBarProgress )+ enteredAmount;
            totalResultTestView.setText("your Total Amount is " + String.valueOf(result)  + " $" );
        }else {
            Toast.makeText(MainActivity.this, "Please Enter your Bill", Toast.LENGTH_LONG).show();
        }

    }
}