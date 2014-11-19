package com.nurvsoft.navigation_drawer.adapter;


import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nurvsoft.navigation_drawer.R;

public class BookOneAdapter extends PagerAdapter {
	
	
	public static final int [] newBookOneImg = {R.drawable.new_jan, R.drawable.new_feb};

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return newBookOneImg.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		
		return view == object;
	}
	
	@Override
	public View instantiateItem(ViewGroup container, int position) {
		
		ImageView photoview = new ImageView(container.getContext());
		photoview.setImageResource(newBookOneImg[position]);
		
		container.addView(photoview, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		return photoview;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		
		container.removeView((View) object);
	}
	
	

}
