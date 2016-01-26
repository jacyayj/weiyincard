package com.example.weiyin.fragment;

import java.util.ArrayList;

import com.example.weiyin.adapter.NewsAdapter;
import com.example.weiyin.card.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class NewsFragment extends Fragment{
	private View rootView = null;
	@ViewInject(R.id.news_listview)
	private ListView listView = null;
	private NewsAdapter adapter = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		rootView = inflater.inflate(R.layout.fragment_news,null);
		ViewUtils.inject(this,rootView);
		init();
		return rootView;
	}
	
	private void init() {
		// TODO �Զ����ɵķ������
		final ArrayList<String> data = new ArrayList<String>();
		data.add("��Ϣ1");
		data.add("��Ϣ2");
		data.add("��Ϣ3");
		
		adapter = new NewsAdapter(getActivity());
		listView.setAdapter(adapter);
		adapter.refresh(data);
		
	}
	
	@OnClick({R.id.news_back})
	private void onClick(View v){
		switch (v.getId()) {
		case R.id.news_back : getActivity().onBackPressed();
			
			break;

		default:
			break;
		}
	}
	
}
