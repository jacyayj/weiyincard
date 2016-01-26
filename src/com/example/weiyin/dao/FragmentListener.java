package com.example.weiyin.dao;


import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public interface FragmentListener {
	
	void setManager(FragmentManager arg);

//	public void add(List<Fragment> arg1);

	void show(Fragment arg);
	
	void goHome();
	
//	public void commit();
//	
	void goBack();
	
//	
//	public void next(int arg);
//	
//	public boolean canGoBack();

	void setMessage(String result);

	String getMessage();
	
	void setBitMap(Bitmap bitmap);
	
	Bitmap getBitmap();
}
