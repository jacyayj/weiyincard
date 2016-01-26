package com.example.weiyin.dao;

public interface HttpHelper {
	
	void onStart();
	
	void onFail(String errormessge,int errorcode,String failreson);
	
	void onSuccess(String result);
	
	void onCencle();
	
	void onCencle(int msg);
	
}
