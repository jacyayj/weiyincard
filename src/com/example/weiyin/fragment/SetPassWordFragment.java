package com.example.weiyin.fragment;

import com.example.weiyin.card.R;
import com.example.weiyin.dao.FragmentListener;
import com.example.weiyin.operation.FragmentListenerImpl;
import com.example.weiyin.utils.ContextUtli;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SetPassWordFragment extends Fragment {
	private FragmentListener fragmentListener = null;
	private View rootView = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		rootView = inflater.inflate(R.layout.fragment_setpwd,null);
		ViewUtils.inject(this,rootView);
		fragmentListener = FragmentListenerImpl.getInstance();
		return rootView;
	}
	
	@OnClick({R.id.set_comfirm,R.id.set_back})
	private void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.set_comfirm : ContextUtli.Toast(getActivity(), "设置成功");
			
			break;
		case R.id.set_back : fragmentListener.goBack();
		
		break;
		default:
			break;
		}
	}
	
}
