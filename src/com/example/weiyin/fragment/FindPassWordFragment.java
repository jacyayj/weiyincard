package com.example.weiyin.fragment;

import com.example.weiyin.card.R;
import com.example.weiyin.dao.FragmentListener;
import com.example.weiyin.operation.FragmentListenerImpl;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FindPassWordFragment extends Fragment {
	
	private FragmentListener fragmentListener = null;
	private View rootView = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		rootView = inflater.inflate(R.layout.fragment_findpwd,null);
		ViewUtils.inject(this,rootView);
		fragmentListener = FragmentListenerImpl.getInstance();
		return rootView;
	}
	
	@OnClick({R.id.find_comfirm,R.id.find_back})
	private void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.find_comfirm : fragmentListener.show(new SetPassWordFragment());
			
			break;
		case R.id.find_back : fragmentListener.goBack();
		
			break;
		default:
			break;
		}
	}
}
