package com.example.weiyin.operation;


import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.weiyin.card.R;
import com.example.weiyin.dao.FragmentListener;
	/**
	 * Fragment操作类
	 * @author jacyayj
	 */
public class FragmentListenerImpl implements FragmentListener {
	
	private Bitmap bitmap = null;
	
	private String result = null;
	
	private FragmentManager manager = null;
	
	private static FragmentListener instance = new FragmentListenerImpl();
	
	private FragmentTransaction transaction = null;
	
	public static FragmentListener getInstance() {
		return instance;
	}
	
	private FragmentListenerImpl(){
	}

//	/**
//	 * 添加所有Fragment
//	 */
//	@Override
//	public void add(List<Fragment> arg1) {
//		// TODO 自动生成的方法存根
//		manager.setFragmentList(arg1);
//		commit();
//	}
	
	/**
	 * 显示fragment
	 */
	@Override
	public void show(Fragment arg) {
		// TODO 自动生成的方法存根
		transaction = manager.beginTransaction();
		transaction.setCustomAnimations(R.anim.fragment_open,R.anim.fragment_close, R.anim.fragment_back_open, R.anim.fragment_back_close);
		transaction.replace(R.id.context,arg);
		transaction.addToBackStack(null);
		transaction.commit();
//		manager.show(arg);
	}
	
//	/**
//	 * 执行添加操作
//	 */
//	@Override
//	public void commit() {
//		// TODO 自动生成的方法存根
//		manager.add();
//	}
	
//	/**
//	 * 设置fragmentmanager
//	 */
//	@Override
	public void setManager(FragmentManager arg) {
		// TODO 自动生成的方法存根
		this.manager = arg;
//		manager = new MfragmentManager(arg);
	}

	@Override
	public void goHome() {
		// TODO 自动生成的方法存根
		System.out.println(manager.getBackStackEntryCount());
		manager.popBackStack(1, manager.getBackStackEntryCount());
//		System.out.println(manager.getBackStackEntryCount());
//		transaction = manager.beginTransaction();
//		transaction.replace(R.id.context,Params.fragment.MAIN_FRAGMENT);
//		transaction.addToBackStack(null);
//		transaction.commit();
		System.out.println(manager.getBackStackEntryCount());
	}
	
	/**
	 * 显示上一个fragment
	 */
	@Override
	public void goBack() {
		// TODO 自动生成的方法存根
		manager.popBackStack();
	}

	@Override
	public void setMessage(String result) {
		// TODO 自动生成的方法存根
		this.result = result;
	}

	@Override
	public String getMessage() {
		// TODO 自动生成的方法存根
		if (result !=null) {
			return result;
		}
		return null;
	}

	@Override
	public void setBitMap(Bitmap bitmap) {
		// TODO 自动生成的方法存根
		this.bitmap = bitmap;
	}

	@Override
	public Bitmap getBitmap() {
		// TODO 自动生成的方法存根
		if (bitmap !=null) {
			return bitmap;
		}
		return null;
	}
//	/**
//	 * 显示下一个fragment
//	 */
//	@Override
//	public void next(int arg) {
//		// TODO 自动生成的方法存根
//		manager.next(arg);
//	}
//
//	@Override
//	public boolean canGoBack() {
//		// TODO 自动生成的方法存根
//		return manager.canGoBack();
//	}
}
