package com.example;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import android.support.v7.internal.view.menu.*;
import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Set;



public class WishList extends Activity {
	
	EditText wisheditText;
	Button addWishButton;
	ListView wishListView;
	
	ArrayList<Item> arrayList;
	BaseAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wish_list);
		initializeAll();
	}

	public void initializeAll(){
		wisheditText=(EditText) findViewById(R.id.newWisheditText1);
		addWishButton=(Button) findViewById(R.id.addWishButton);
		wishListView=(ListView) findViewById(R.id.wishListView);
		arrayList = new ArrayList<Item>();
		adapter = new BaseAdapter() {
			
			LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			@Override
			public View getView(int position, View view, ViewGroup viewGroup) {
				if(view == null){
					view = inflater.inflate(R.layout.wish_list_item, null);
				}
				
				TextView wishTextView = (TextView) view.findViewById(R.id.wishListItemTextView1);
				TextView dateTextview = (TextView) view.findViewById(R.id.wishListDateTextView2);
				wishTextView.setText(arrayList.get(position).getText());
				 Calendar c = Calendar.getInstance();
			        System.out.println("Current time => "+c.getTime());

			        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        String formattedDate = df.format(c.getTime());
			        // formattedDate have current date/time
			        //Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();


			       //Now we display formattedDate value in TextView
			        //TextView txtView = new TextView(this);
			        //txtView.setText("Current Date and Time : "+formattedDate);
			        //txtView.setGravity(Gravity.CENTER);
			        //txtView.setTextSize(20);
			        //setContentView(txtView);
				//Date date= (arrayList.get(position).getDate());
				//dateTextview.setText(DateFormat.format("dd/MM/yyyy HH:mm:ss a", date));
				

				
				
				
				return view;
			}
			
			@Override
			public long getItemId(int position) {
				
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				return arrayList.get(position);
			}
			
			@Override
			public int getCount() {
				return arrayList.size();
			}
		};
		wishListView.setAdapter(adapter);
		addWishButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String string=wisheditText.getText().toString();
				Date date=new Date();
				Item item =new Item(string);
				arrayList.add(item);
				adapter.notifyDataSetChanged();
				wisheditText.setText(" ");
				InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				inputMethodManager.hideSoftInputFromWindow(wisheditText.getWindowToken(), 0);
				Toast.makeText(getBaseContext(), "New Wish Added To List", Toast.LENGTH_SHORT).show();
				
			}
		});
		wishListView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View view, int position, long ID) {
				arrayList.remove(position);
				adapter.notifyDataSetChanged();
				Toast.makeText(getBaseContext(), "One Item Removed", Toast.LENGTH_SHORT).show();
				return false;
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wish_list, menu);
		return true;
	}

	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
}
