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
	/**
	 * @author jacyayj
	 *
	 */
public class LoginFragment extends Fragment {
	
	private View rootView = null;
	private FragmentListener fragmentListener = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		rootView = inflater.inflate(R.layout.fragment_login, container, false);
		fragmentListener = FragmentListenerImpl.getInstance();
		ViewUtils.inject(this, rootView);
		return rootView;
	}
	
	@OnClick({R.id.login_back,R.id.to_reg,R.id.to_find})
	private void onClick(View v){
		switch (v.getId()) {
		case R.id.login_back : fragmentListener.goBack();
			
			break;
		case R.id.to_reg : fragmentListener.show(new RegFragment());
		
			break;
		case R.id.to_find : fragmentListener.show(new FindPassWordFragment());
			
			break;
		default:
			break;
		}
	}
	
}
