package com.example.firsttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE="com.example.firsttest.MESSAGE";
	public final static String EXTRA_WEIGHT="com.example.firsttest.WEIGHTSTRING";
	public final static String EXTRA_HEIGHT="com.example.firsttest.HEIGHTSTRING";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}   

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//this method will get executed when the user hits the send button on the main screen
		public void sendMessage(View view){
		Intent intent=new Intent(this, DisplayMessageActivity.class);
		
		EditText editText=(EditText)findViewById(R.id.edit_message);
		String Message=editText.getText().toString();
		
		
		
		EditText editText2=(EditText)findViewById(R.id.edit_height);
		String HeightString=editText2.getText().toString();
		
		
		
		EditText editText1=(EditText)findViewById(R.id.edit_weight);
		String WeightString=editText1.getText().toString();
		
		intent.putExtra(EXTRA_MESSAGE, Message);
		intent.putExtra(EXTRA_WEIGHT, WeightString);
		intent.putExtra(EXTRA_HEIGHT, HeightString);
		
		boolean empty=false;
		
		if (editText2.getText() == null || "".equals(editText2.getText().toString())){ 
			empty=true;			
            }
		
		if (editText1.getText() == null || "".equals(editText1.getText().toString())){ 
			empty=true;			
            }
		
		if(empty==true){
			Toast.makeText(getApplicationContext(), "Height or Weight field cannot be empty", Toast.LENGTH_SHORT).show();
		}	
		
		if(empty==false)startActivity(intent);
		//code that works will come here
	}
	public void displayAbout(View view){
		Intent intent=new Intent(this, Aboutbmi.class);
		startActivity(intent);
	}

}
