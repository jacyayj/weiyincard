package com.example.weiyin.adapter;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class GeneralPagerAdapter extends PagerAdapter {
	
	private ArrayList<View> list = null;
	
	public GeneralPagerAdapter(ArrayList<View> list) {
		// TODO �Զ����ɵĹ��캯�����
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO �Զ����ɵķ������
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO �Զ����ɵķ������
		container.removeView(list.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO �Զ����ɵķ������
		container.addView(list.get(position));
		return list.get(position);
	}
	
}
