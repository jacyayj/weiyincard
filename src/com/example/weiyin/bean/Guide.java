package com.example.weiyin.bean;

import java.util.ArrayList;

import com.example.weiyin.card.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Guide extends Activity implements OnPageChangeListener{
	
	@ViewInject(R.id.vip)
	ViewPager pager = null;
	
	ArrayList<ImageView> list = null;
	ImageView[] imageViews = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide_layout);
		ViewUtils.inject(this);
		ViewGroup group = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.guide_item,null);
		list = new ArrayList<ImageView>();
		list.add((ImageView) group.findViewById(R.id.guide_item1));
		list.add((ImageView) group.findViewById(R.id.guide_item2));
		list.add((ImageView) group.findViewById(R.id.guide_item3));
		group.removeAllViews();
		
		imageViews = new ImageView[3];
		imageViews[0] = (ImageView) findViewById(R.id.dot1);
		imageViews[1] = (ImageView) findViewById(R.id.dot2);
		imageViews[2] = (ImageView) findViewById(R.id.dot3);
		
		for (int i = 0; i < imageViews.length; i++) {
			if (i == 0) {
				imageViews[i].setImageResource(R.drawable.guide_dot_black);
			}else {
				imageViews[i].setImageResource(R.drawable.guide_dot_white);
			}
		}
		
		pager.setAdapter(new GuideAdapter());
		pager.setOnPageChangeListener(this);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO 自动生成的方法存根
		for (int i = 0; i < imageViews.length; i++) {
			if (i == arg0) {
				imageViews[i].setImageResource(R.drawable.guide_dot_black);
			}else {
				imageViews[i].setImageResource(R.drawable.guide_dot_white);
			}
		}
	}
	class GuideAdapter extends PagerAdapter{

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
}
