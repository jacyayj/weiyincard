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
		// TODO �Զ����ɵĹ��캯�����
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		data = new ArrayList<ItemSource>();
		
		//��ȡ��Ļ�߶�
		display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
	}
	
	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
		return data.size();
	}

	@Override
	public ItemSource getItem(int arg0) {
		// TODO �Զ����ɵķ������
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO �Զ����ɵķ������
		return arg0;
	}

	public void refresh(List<ItemSource> data) {
		// TODO �Զ����ɵķ������
		this.data = data;
		notifyDataSetChanged();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO �Զ����ɵķ������
		//����viewhodler
		if (arg1 == null) {
			hodler = new ViewHodler();
			arg1 = inflater.inflate(R.layout.coupon_list_item,null);
			
			//����ÿ��item�߶�
			LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,(int)(display.getHeight()*0.15));
			arg1.setLayoutParams(params);
			
			//��ʼ���ؼ�
			hodler.icon = (ImageView) arg1.findViewById(R.id.coupon_item_icon);
			hodler.lable = (TextView) arg1.findViewById(R.id.coupon_item_lable);
			hodler.describe = (TextView) arg1.findViewById(R.id.coupon_item_describe);
			hodler.remark = (TextView) arg1.findViewById(R.id.coupon_item_remark);
			arg1.setTag(hodler);
		}else {
			hodler = (ViewHodler) arg1.getTag();
		}
		
		//���������õ�ҳ��ؼ���
		hodler.icon.setImageResource(data.get(arg0).getIcon());
		hodler.lable.setText(data.get(arg0).getLable());
		hodler.describe.setText(data.get(arg0).getDescribe());
		hodler.remark.setText(data.get(arg0).getRemark());
		
		return arg1;
	}
	/**
	 * ������������
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
