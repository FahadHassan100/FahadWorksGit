package com.nurvsoft.navigation_drawer.model;


public class NavItems {
	
	private int icon;
	private String title;
	private String count = "0";
	//private boolean isCounter = false;
	
	
	public NavItems(int para_icon, String para_title){
		
		this.icon = para_icon;
		this.title = para_title;
		
	}


	public int getIcon() {
		return this.icon;
	}


	public void setIcon(int icon) {
		this.icon = icon;
	}


	public String getTitle() {
		return this.title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCount() {
		return this.count;
	}


	public void setCount(String count) {
		this.count = count;
	}
	

}
