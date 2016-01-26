package com.example.weiyin.fragment;

import java.util.ArrayList;

import com.example.weiyin.adapter.MyCouponAdapter;
import com.example.weiyin.card.R;
import com.example.weiyin.patterns.ItemSource;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MyCouponFragment extends Fragment{
	private View rootView = null;
	@ViewInject(R.id.mycoupon_listview)
	private ListView listView = null;
	private MyCouponAdapter adapter = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		rootView = inflater.inflate(R.layout.fragment_mycoupon,null);
		ViewUtils.inject(this,rootView);
		init();
		return rootView;
	}
	
	private void init() {
		// TODO 自动生成的方法存根
		final ArrayList<ItemSource> data = new ArrayList<ItemSource>();
		ItemSource source = new ItemSource(R.drawable.icon_dicos, R.drawable.item_bg2,"德克士", "fgasfdfafasfas","100");
		ItemSource source2 = new ItemSource(R.drawable.icon_dq, R.drawable.item_bg1,"DQ", "fgasfdfafasfas","100");
		ItemSource source3 = new ItemSource(R.drawable.icon_startbucks, R.drawable.item_bg3,"星巴克", "fgasfdfafasfas","100");
		data.add(source);
		data.add(source2);
		data.add(source3);
		
		adapter = new MyCouponAdapter(getActivity());
		listView.setAdapter(adapter);
		adapter.refresh(data);
		
	}
	
	@OnClick({R.id.mycoupon_back})
	private void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.mycoupon_back : getActivity().onBackPressed();
			
			break;

		default:
			break;
		}
	}
}
