package com.example.weiyin.fragment;


import com.example.weiyin.card.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FeedBackFragment extends Fragment{
	private View rootView = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		rootView = inflater.inflate(R.layout.fragment_feedback,null);
		ViewUtils.inject(this,rootView);
		init();
		return rootView;
	}
	
	private void init() {
		// TODO �Զ����ɵķ������
		
	}
	
	@OnClick({R.id.feedback_back})
	private void onClick(View v){
		switch (v.getId()) {
		case R.id.feedback_back : getActivity().onBackPressed();
			
			break;

		default:
			break;
		}
	}
	
}
