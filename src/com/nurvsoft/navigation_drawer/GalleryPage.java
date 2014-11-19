package com.nurvsoft.navigation_drawer;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class GalleryPage extends Fragment {
	
	

	public GalleryPage(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		Toast.makeText(getActivity(), "Gallery", Toast.LENGTH_SHORT).show();
		
		View MainView = inflater.inflate(R.layout.gallerypage, container, false);
		return MainView;
		
	}

}
