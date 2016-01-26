/**
 * 
 */
package com.example.weiyin.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.weiyin.card.R;
import com.example.weiyin.patterns.ItemSource;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AbsListView.LayoutParams;

/**
 * @author jacyayj
 *
 */
public class CouPonAdapter extends BaseAdapter {

	private List<ItemSource> data = null;
	private LayoutInflater inflater = null;
	private ViewHodler hodler = null;
	Display display = null;
	public CouPonAdapter(Context context) {
		// TODO 自动生成的构造函数存根
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		data = new ArrayList<ItemSource>();
		
		//获取屏幕高度
		display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
	}
	
	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return data.size();
	}

	@Override
	public ItemSource getItem(int arg0) {
		// TODO 自动生成的方法存根
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO 自动生成的方法存根
		return arg0;
	}

	public void refresh(List<ItemSource> data) {
		// TODO 自动生成的方法存根
		this.data = data;
		notifyDataSetChanged();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO 自动生成的方法存根
		//设置viewhodler
		if (arg1 == null) {
			hodler = new ViewHodler();
			arg1 = inflater.inflate(R.layout.coupon_list_item,null);
			
			//设置每个item高度
			LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,(int)(display.getHeight()*0.15));
			arg1.setLayoutParams(params);
			
			//初始化控件
			hodler.icon = (ImageView) arg1.findViewById(R.id.coupon_item_icon);
			hodler.lable = (TextView) arg1.findViewById(R.id.coupon_item_lable);
			hodler.describe = (TextView) arg1.findViewById(R.id.coupon_item_describe);
			hodler.remark = (TextView) arg1.findViewById(R.id.coupon_item_remark);
			arg1.setTag(hodler);
		}else {
			hodler = (ViewHodler) arg1.getTag();
		}
		
		//将数据设置到页面控件中
		hodler.icon.setImageResource(data.get(arg0).getIcon());
		hodler.lable.setText(data.get(arg0).getLable());
		hodler.describe.setText(data.get(arg0).getDescribe());
		hodler.remark.setText(data.get(arg0).getRemark());
		
		return arg1;
	}
	/**
	 * 适配器辅助类
	 * @author jacyayj
	 *
	 */
	class ViewHodler{
		private ImageView icon = null;
		private TextView lable = null;
		private TextView describe = null;
		private TextView remark =null;
	}

}
