package com.nurvsoft.navigation_drawer.adapter;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nurvsoft.navigation_drawer.R;
import com.nurvsoft.navigation_drawer.model.NavItems;

public class DrawerAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<NavItems> mNavItems;

	public DrawerAdapter(Context context, ArrayList<NavItems> mNavItems) {
		this.context = context;
		this.mNavItems = mNavItems;
	}

	@Override
	public int getCount() {
		return mNavItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mNavItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater mlayoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mlayoutInflater.inflate(R.layout.drawer_list_layout, null);
		}
		
		ImageView Icon = (ImageView) convertView.findViewById(R.id.img);
		TextView title = (TextView) convertView.findViewById(R.id.title);
		
		Icon.setImageResource(mNavItems.get(position).getIcon());
		title.setText(mNavItems.get(position).getTitle());

		return convertView;
	}
}
