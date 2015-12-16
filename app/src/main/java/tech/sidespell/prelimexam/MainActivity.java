package tech.sidespell.prelimexam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTextView;
    private ToggleButton mToggleButton;

    private long timeRemaining = 0;
    private SeekBar timeSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        timeSpeed = (SeekBar) findViewById(R.id.seekBar);


        timeSpeed.setProgress(0);
        timeSpeed.incrementProgressBy(10);
        timeSpeed.setMax(1000);
        TextView seekBarValue = (TextView)layout.findViewById(R.id.seekBar);
        seekBarValue.setText(tvRadius.getText().toString().trim());


        mTextView = (TextView) findViewById(R.id.textView);
        mToggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        mToggleButton.setOnCheckedChangeListener(this);




        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                timeRemaining += 1;
                mTextView.setText(timeRemaining + "");

                if (timeRemaining > 0) {
                    handler.postDelayed(this, 1000);
                }
            }
        };

        handler.postDelayed(runnable, 1000);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Log.d(TAG, "onCheckedChanged: ON");
            // TODO: Create an alert dialog to ask user input

            LayoutInflater inflater = LayoutInflater.from(this);
            View view = inflater.inflate(R.layout.content_main, null);

             RadioButton userPickInc = (RadioButton) view.findViewById(R.id.radioButton);
             RadioButton userPickDec = (RadioButton) view.findViewById(R.id.radioButton2);

        } else {
            Log.d(TAG, "onCheckedChanged: OFF");
        }
    }


}
