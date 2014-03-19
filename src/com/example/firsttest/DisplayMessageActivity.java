package com.example.firsttest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Show the Up button in the action bar.
		Intent intent=getIntent();
		String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		String weight=intent.getStringExtra(MainActivity.EXTRA_WEIGHT);
		String height=intent.getStringExtra(MainActivity.EXTRA_HEIGHT);
		float weightValue=Float.parseFloat(weight);
		float heightValue=Float.parseFloat(height);
		heightValue/=100;
		heightValue*=heightValue;
		float bmi=weightValue/heightValue;
		TextView textView = new TextView(this);
        textView.setTextSize(25); 
        String status; String range; 
        if(bmi>0&&bmi<15){status="Very Severely Underweight";range="less than 15";}
        else if(bmi>=15&&bmi<16){status="Thin";range="between 15 and 16";}
        else if(bmi>=16&&bmi<18.5){status="Underweight";range="between 16 and 18.5";}
        else if(bmi>=18.5&&bmi<25){status="Normal (Healthy Weight)";range="between 18.5 and 25";}
	    else if(bmi>=25&&bmi<30){status="Overweight";range="between 25 and 30";}
	    else if(bmi>=30&&bmi<35){status="Moderately Obese";range="between 30 and 35";}
	    else if(bmi>=35&&bmi<40){status="Severely Obese";range="between 35 and 40";}
	    else {status="Very Severely Obese";range="over 40";}
        
        textView.setText(" Hello "+message+" !! \n\n Your BMI is "+bmi+" \n\n You are "+status+
        		"\n\n NOTE: BMI range for being "+status+" is "+range);        
            setupActionBar();
            setContentView(textView);
	}
        
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            }
            return super.onOptionsItemSelected(item);
        }


	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
	
	
	}

	
	

	


