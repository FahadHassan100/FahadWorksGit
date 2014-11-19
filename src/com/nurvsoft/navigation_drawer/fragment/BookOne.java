package com.nurvsoft.navigation_drawer.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;

import com.nurvsoft.navigation_drawer.R;
import com.nurvsoft.navigation_drawer.R.string;
import com.nurvsoft.navigation_drawer.adapter.BookOneAdapter;
import com.nuvrsoft.viewpager.animations.ZoomOutPageTransformer;
import com.nuvrsoft.viewpager.base.BaseFragment;

public class BookOne extends BaseFragment{

	
	private static final String ISLOCK = "section Num";
	private static final String ISLOCK_ARG = "isLocked";
	
	private ViewPager mViewPager;
	private MenuItem menuLockItem;
	
	View mBookView;
	Context mContext;
	
	
	
	public BookOne(){
		
		
	}
	
	@Override
	public int getTitleResourceId() {
		
		
		return R.string.app_name;
	}
	
	public static BookOne newInstance(int sectoinName){
		
		BookOne fragment = new BookOne();
		Bundle args = new Bundle();
		args.putInt(ISLOCK, sectoinName);
		fragment.setArguments(args);
		return fragment;
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		setHasOptionsMenu(true);
		
		mBookView = inflater.inflate(R.layout.fragmentbookone, container, false);
		mContext = mBookView.getContext();
		setReference();
		
		mViewPager.setAdapter(new BookOneAdapter());
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	public void setReference(){
		
		mViewPager = (ViewPager) mBookView.findViewById(R.id.bookOneViewPager);
		mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
		
		
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		
		inflater.inflate(R.menu.viewpager_menu, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
	

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		
		menuLockItem = menu.findItem(R.id.menu_lock);
		
		menuLockItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				
				return true;
			}
		});
		
	}
	
	private boolean isViewPagerActive(){
		
		return (mViewPager != null && mViewPager instanceof ViewPager);
		
	}

}
