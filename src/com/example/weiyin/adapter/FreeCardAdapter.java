package com.example.weiyin.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.weiyin.card.R;
import com.example.weiyin.patterns.ItemSource;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
	/**
	 * �Զ��忨��listview������
	 * @author jacyayj
	 *
	 */
public class FreeCardAdapter extends BaseAdapter{
	
	private List<ItemSource> data = null;
	private LayoutInflater inflater = null;
	private ViewHodler hodler = null;
	Display display = null;
	public FreeCardAdapter(Context context) {
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
			arg1 = inflater.inflate(R.layout.freecard_item,null);
			
			//����ÿ��item�߶�
			LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,(int)(display.getHeight()*0.13));
			arg1.setLayoutParams(params);
			
			//��ʼ���ؼ�
			hodler.icon = (ImageView) arg1.findViewById(R.id.addcard_item_icon);
			hodler.lable = (TextView) arg1.findViewById(R.id.addcard_item_lable);
			hodler.describe = (TextView) arg1.findViewById(R.id.addcard_item_describe);
			hodler.get = (Button) arg1.findViewById(R.id.addcard_get);
			arg1.setTag(hodler);
		}else {
			hodler = (ViewHodler) arg1.getTag();
		}
		
		//���������õ�ҳ��ؼ���
		arg1.setBackgroundResource(data.get(arg0).getBackground());
		hodler.icon.setImageResource(data.get(arg0).getIcon());
		hodler.lable.setText(data.get(arg0).getLable());
		hodler.describe.setText(data.get(arg0).getDescribe());
		hodler.get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				System.out.println("��ȡ");
			}
		});
		
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
		private Button get =null;
	}
}
