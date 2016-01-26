package com.example.weiyin.fragment;


import com.example.weiyin.card.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutUsFragment extends Fragment{
	@ViewInject(R.id.version)
	private TextView version = null;
	private View rootView = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		rootView = inflater.inflate(R.layout.fragment_aboutus,null);
		ViewUtils.inject(this,rootView);
		init();
		return rootView;
	}
	
	private void init() {
		// TODO 自动生成的方法存根
		try {
			version.setText("v "+getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName);
		} catch (NameNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@OnClick({R.id.aboutus_back})
	private void onClick(View v){
		switch (v.getId()) {
		case R.id.aboutus_back : getActivity().onBackPressed();
			
			break;

		default:
			break;
		}
	}
	
}
