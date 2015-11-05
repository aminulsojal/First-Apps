package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class ActivitySojal1 extends Activity {
	
	TextView textView1;
	Button gotoWishListButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_sojal1);
		
		textView1=(TextView) findViewById(R.id.textView1);
		gotoWishListButton=(Button) findViewById(R.id.gotoWishListButton);
		gotoWishListButton.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				//button on press method
				Intent intent = new Intent(ActivitySojal1.this,WishList.class);
				startActivity(intent);
				
			}
		});
		textView1.setText("WELCOME!!\n"+getIntent().getStringExtra("PERSON_NAME"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sojal, menu);
		return true;
	}
}

