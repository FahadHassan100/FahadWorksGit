package com.nurvsoft.navigation_drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;

public class ScreenSliderPagerView extends FragmentActivity {

	
	private static final int NUM_PAGES = 5;

    
    private ViewPager mPager;

    
    private PagerAdapter mPagerAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.fragmentbookone);
    	
    	mPager = (ViewPager)findViewById(R.id.bookOneViewPager);
    	
    }
    
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{
    	public ScreenSlidePagerAdapter(FragmentManager fm){
    		super(fm);
    		
    	}
    	
    	@Override
    	public Fragment getItem(int position) {
    		// TODO Auto-generated method stub
    		return new Fragment();
    	}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_PAGES;
		}
    	
    	
    	
    }
    
}
