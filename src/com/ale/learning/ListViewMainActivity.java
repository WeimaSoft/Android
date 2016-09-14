package com.ale.learning;

import com.ale.learning.listview.SimpleListViewActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ListViewMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_main);
		
		setUpButtonListner(R.id.btnSimpleListView, setUpClickListner(SimpleListViewActivity.class));
	}
	
	private OnClickListener setUpClickListner(final Class<?> classRef)
	{
		return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListViewMainActivity.this, classRef);
				startActivity(intent);
			}
		};
	}
	
	private void setUpButtonListner(int buttonId, OnClickListener listner) {
		Button btnList = (Button) findViewById(buttonId);
		btnList.setOnClickListener(listner);
	}
}
