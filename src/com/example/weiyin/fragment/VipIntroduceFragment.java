package com.example.weiyin.fragment;

import java.util.ArrayList;

import com.example.weiyin.adapter.GeneralPagerAdapter;
import com.example.weiyin.adapter.VipIntroduceAdapter;
import com.example.weiyin.card.R;
import com.example.weiyin.dao.FragmentListener;
import com.example.weiyin.operation.FragmentListenerImpl;
import com.example.weiyin.patterns.ItemSource;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class VipIntroduceFragment extends Fragment {
	
	private View rootView = null;
	@ViewInject(R.id.vip_introduce_title)
	private TextView title = null;
	private FragmentListener fragmentListener = null;
	@ViewInject(R.id.vip_introduce_content)
	private ListView listView = null;
	@ViewInject(R.id.vip_introduce_card)
	private ViewPager pager = null;
	private ArrayList<View> pageritem = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		rootView = inflater.inflate(R.layout.fragment_vipintroduce,null);
		ViewUtils.inject(this,rootView);
		fragmentListener = FragmentListenerImpl.getInstance();
		title.setText(fragmentListener.getMessage());
		init();
		return rootView;
	}
	
	private void init() {
		// TODO 自动生成的方法存根
		ArrayList<ItemSource> data = new ArrayList<ItemSource>();
		String[] lables = getResources().getStringArray(R.array.vipintroduce_lable_array);
		for (int i = 0; i < lables.length; i++) {
			data.add(new ItemSource(R.drawable.vip_introduce_icon1+i,lables[i], "content"+i));
		}
		VipIntroduceAdapter adapter = new VipIntroduceAdapter(getActivity());
		listView.setAdapter(adapter);
		adapter.refresh(data);
		
		pageritem = new ArrayList<View>();
		View v = getActivity().getLayoutInflater().inflate(R.layout.vip_introduce_vip_item, null);
		pageritem.add((ImageView)v.findViewById(R.id.vip_viewpager_item1));
		pageritem.add((ImageView)v.findViewById(R.id.vip_viewpager_item2));
		pager.setAdapter(new GeneralPagerAdapter(pageritem));
	}
	
	@OnClick({R.id.vip_introduce_back})
	private void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.vip_introduce_back : getActivity().onBackPressed();
			
			break;

		default:
			break;
		}
	}
}
