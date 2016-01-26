package com.example.weiyin.adapter;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class GeneralPagerAdapter extends PagerAdapter {
	
	private ArrayList<View> list = null;
	
	public GeneralPagerAdapter(ArrayList<View> list) {
		// TODO 自动生成的构造函数存根
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO 自动生成的方法存根
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO 自动生成的方法存根
		container.removeView(list.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO 自动生成的方法存根
		container.addView(list.get(position));
		return list.get(position);
	}
	
}
