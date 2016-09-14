package com.ale.learning.listview;

import com.ale.learning.R;
import com.ale.learning.R.layout;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomizeBaseAdapterActivity extends ListActivity {
	private final String[] titles = { "Name", "Age", "Sex" };
	MyAdapter adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		adapter = new MyAdapter(this);
		
		setListAdapter(adapter);
	}

	class MyAdapter extends BaseAdapter {

		private Context _context = null;

		public MyAdapter(Context context) {
			_context = context;
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public Object getItem(int position) {
			return titles[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView iamge = null;
			TextView title = null;
			if (convertView == null) {
				convertView = LayoutInflater.from(_context).inflate(R.layout.listview_base_adapter, null);
				iamge = (ImageView) convertView.findViewById(R.id.customize_base_adapter_img);
				title = (TextView) convertView.findViewById(R.id.customize_base_adapter_text1);
			}
			title.setText(titles[position]);
			iamge.setImageResource(R.drawable.demo);
			return convertView;
		}

	}
}
