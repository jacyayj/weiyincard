package com.example.weiyin.operation;

import java.util.ArrayList;
import java.util.List;

import com.example.weiyin.adapter.CouPonAdapter;
import com.example.weiyin.adapter.FreeCardAdapter;
import com.example.weiyin.patterns.ItemSource;
import com.example.weiyin.patterns.Params;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.BaseAdapter;

public class EditTextSearchListener implements TextWatcher{
	List<ItemSource> data = null;
	BaseAdapter adapter = null;
	ArrayList<ItemSource> searchlist = null;
	int flag = -1;
	
	public EditTextSearchListener(BaseAdapter adapter,List<ItemSource> data,int flag) {
		// TODO 自动生成的构造函数存根
		this.adapter = adapter;
		this.data = data;
		this.flag = flag;
	}
	
	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO 自动生成的方法存根
		searched(arg0.toString());
		if (flag == Params.flag.FREECARD_FLAG) {
			if ("".equals(arg0.toString())) {
				 ((FreeCardAdapter) adapter).refresh(data);
			}else {
				((FreeCardAdapter) adapter).refresh(searchlist);
			}
		}else if(flag == Params.flag.COUPON_FLAG){
			if ("".equals(arg0.toString())) {
				 ((CouPonAdapter) adapter).refresh(data);
			}else {
				((CouPonAdapter) adapter).refresh(searchlist);
			}
		}
	}
	private void searched(String lable) {
		// TODO 自动生成的方法存根

		searchlist = new ArrayList<ItemSource>();
        for (int i = 0; i < data.size(); i++) {  
            int index = data.get(i).getLable().indexOf(lable);  
            // 存在匹配的数据  
            if (index != -1) {  
                searchlist.add(data.get(i));  
                System.out.println(data.get(i).getLable());
            }  
        }  
    
	}
}
