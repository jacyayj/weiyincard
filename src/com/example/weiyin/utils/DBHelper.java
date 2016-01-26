package com.example.weiyin.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	
	private String name = null;
//	private int version = 0;
	
	public DBHelper(Context context, String name, int version) {
		super(context, name, null, version);
		// TODO �Զ����ɵĹ��캯�����
		this.name = name;
//		this.version = version;
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO �Զ����ɵķ������
		String sql = "create table "+name+"(_id integer primarykey,name varchar(20),remark varchar)";
		arg0.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO �Զ����ɵķ������
		
	}

}
