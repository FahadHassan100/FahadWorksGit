package com.nurvsoft.navigation_drawer;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nurvsoft.navigation_drawer.fragment.BookOne;

public class HomePage extends Fragment {
	
	Context mContext;

	public HomePage(){
	
	
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		//Toast.makeText(getActivity(), "Home", Toast.LENGTH_SHORT).show();
		//getSupportFragmentManager().beginTransaction().add(R.id.container, new BookOne()).commit();
		
		
		ViewGroup MainView = (ViewGroup)inflater.inflate(R.layout.home_page, container, false);
		
		//View MainView = inflater.inflate(R.layout.fragmentbookone, container, false);
		
		//getFragmentManager().beginTransaction().add(R.id.container, new BookOne()).commit();
		
		
		return MainView;
		
	}
	
	/*@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		
		getFragmentManager().beginTransaction().add(R.id.container, new BookOne()).commit();
		//Toast.makeText(getActivity(), "check activity", Toast.LENGTH_SHORT).show();
		
	}*/

	
	
	
	

}
