package com.example.weiyin.fragment;

import com.example.weiyin.card.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ActivityDetailsFragment extends Fragment{
	
	private View rootView = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		rootView = inflater.inflate(R.layout.fragment_activitydetails,null);
		return rootView;
	}
}
