package com.alessandro.counter;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
	TextView score;

	private int counter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	    btn1 = (Button) findViewById(R.id.aggiungi);
	    btn2 = (Button) findViewById(R.id.reset);
	    score = (TextView) findViewById(R.id.score);

	    btn1.setOnClickListener(this);
	    btn2.setOnClickListener(this);


    }

	@Override
	public void onClick(View view) {
		Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		if (view == btn1) {
			vibe.vibrate(50);
			counter++;
			score.setText(Integer.toString(counter));
		}
		if (view == btn2) {
			//vibe.vibrate(100);
			counter = 0;
			score.setText(Integer.toString(counter));
			Toast.makeText(getBaseContext(), R.string.reset_message, Toast.LENGTH_SHORT).show();
		}
	}
}
