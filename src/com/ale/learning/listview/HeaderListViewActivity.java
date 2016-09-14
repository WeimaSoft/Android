package com.ale.learning.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class HeaderListViewActivity extends ListActivity {
	private final String[] titles = { "Name", "Age", "Sex" };
	private final String[] texts = { "Ale", "33", "Male" };
	ListView listView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		listView = getListView();
		
		ArrayList<Map<String, String>> data = new ArrayList<Map<String,String>>();
		
		for (int i = 0; i < titles.length; i++) {
			Map<String, String> dataItem = new HashMap<String,String>();
			dataItem.put("title", titles[i]);
			dataItem.put("text", texts[i]);
			
			data.add(dataItem);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2, new String[]{"title","text"}, new int[]{android.R.id.text1, android.R.id.text2});
		
		setListAdapter(adapter);
	}
}
