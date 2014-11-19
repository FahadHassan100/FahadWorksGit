package com.nurvsoft.navigation_drawer;

import java.util.ArrayList;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nurvsoft.navigation_drawer.adapter.DrawerAdapter;
import com.nurvsoft.navigation_drawer.model.NavItems;

public class MainActivity extends ActionBarActivity {

	private DrawerLayout mDrawerLayout;
	private ListView mListView;
	private ActionBarDrawerToggle mActionBarToggle;

	private CharSequence DrawerTitle;
	private CharSequence mTitle;

	private String[] mNavName;
	private TypedArray mNavIcon;

	private ArrayList<NavItems> mNavList;
	private DrawerAdapter adapter;
	
	View header;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRef();
		
		mTitle = DrawerTitle = getTitle();
		mNavName = getResources().getStringArray(R.array.friends);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		
		mListView = (ListView) findViewById(R.id.drawerList);
		
		
		//View header = getLayoutInflater().inflate(R.layout.header, null);
		/*header = getLayoutInflater().inflate(R.layout.secheader, null);
		mListView.addHeaderView(header);*/
		
		mNavIcon = getResources().obtainTypedArray(R.array.nav_icons);
		
		mNavList = new ArrayList<NavItems>();
		mNavList.add(new NavItems(mNavIcon.getResourceId(0, -1), mNavName[0]));
		mNavList.add(new NavItems(mNavIcon.getResourceId(1, -1), mNavName[1]));
		mNavList.add(new NavItems(mNavIcon.getResourceId(2, -1), mNavName[2]));
		mNavList.add(new NavItems(mNavIcon.getResourceId(3, -1), mNavName[3]));
		mNavList.add(new NavItems(mNavIcon.getResourceId(4, -1), mNavName[4]));
		
		

		mNavIcon.recycle();

		mListView.setOnItemClickListener(new SlideMenuClickListener());

		adapter = new DrawerAdapter(getApplicationContext(), mNavList);
		mListView.setAdapter(adapter);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		mActionBarToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {

			@Override
			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(mTitle);
				supportInvalidateOptionsMenu();
			}
			
			@Override
			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(DrawerTitle);
				supportInvalidateOptionsMenu();

			}


		};

		mDrawerLayout.setDrawerListener(mActionBarToggle);

		if (savedInstanceState == null) {

			displayView(0);

		}
	}

	public class SlideMenuClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> paret, View view, int position,
				long id) {
			 displayView(position);

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		if(mActionBarToggle.onOptionsItemSelected(item)){
			
			return true;
			
		}
		
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		
		boolean navOpen = mDrawerLayout.isDrawerOpen(mListView);
		menu.findItem(R.id.action_settings).setVisible(!navOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	public void setRef() {

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		mListView = (ListView) findViewById(R.id.drawerList);

	}

	private void displayView(int position) {

		Fragment fragment = null;
		switch (position) {
			case 0:
				fragment = new HomePage();
				break;
			case 1:
				fragment = new HomePage();
				break;
			case 2:
				fragment = new GalleryPage();
				break;
			case 3:
				fragment = new HomePage();
				break;
			case 4:
				fragment = new HomePage();
				break;
			default:
				break;
		}
		
		if(fragment != null){
			
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.mainContant, fragment).commit();
			
			mListView.setItemChecked(position, true);
			mListView.setSelection(position);
			setTitle(mNavName[position]);
			mDrawerLayout.closeDrawer(mListView);
			
		}else{
			
			Log.e("MainActivity", "erro");
			
		}

	}
	
	@Override
	public void setTitle(CharSequence title) {
		
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
		
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		mActionBarToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		mActionBarToggle.onConfigurationChanged(newConfig);
	}

}
