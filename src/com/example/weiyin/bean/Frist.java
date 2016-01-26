package com.example.weiyin.bean;

import com.example.weiyin.card.R;
import com.example.weiyin.dialog.SpotsDialog;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Frist extends Activity{
	SpotsDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frist);
		ViewUtils.inject(this);
	}

	@OnClick({R.id.had_card,R.id.free_card})
	private void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.had_card : 
				dialog = new SpotsDialog(this);
				dialog.show();
//			startActivity(new Intent(Frist.this,MainActivity.class));finish();
			break;
		case R.id.free_card : 
				startActivity(new Intent(Frist.this,MainActivity.class));finish();
			break;
		default:
			break;
		}
	}
}