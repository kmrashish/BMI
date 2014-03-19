package com.example.firsttest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Aboutbmi extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aboutbmi);
		TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setText("\n Body Mass Index (BMI), or Quetelet index, is a measure for human body shape based" +
        		" on an individual's mass and height. \n \n It is defined as the individual's body " +
        		"mass divided by the square of their height - with the value universally being given " +
        		"in units of kg/m^2.");
		// Show the Up button in the action bar.
		setupActionBar();
		setContentView(textView);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aboutbmi, menu);
		return true;
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


}
