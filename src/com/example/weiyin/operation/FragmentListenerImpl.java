package com.example.weiyin.operation;


import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.weiyin.card.R;
import com.example.weiyin.dao.FragmentListener;
	/**
	 * Fragment������
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
//	 * �������Fragment
//	 */
//	@Override
//	public void add(List<Fragment> arg1) {
//		// TODO �Զ����ɵķ������
//		manager.setFragmentList(arg1);
//		commit();
//	}
	
	/**
	 * ��ʾfragment
	 */
	@Override
	public void show(Fragment arg) {
		// TODO �Զ����ɵķ������
		transaction = manager.beginTransaction();
		transaction.setCustomAnimations(R.anim.fragment_open,R.anim.fragment_close, R.anim.fragment_back_open, R.anim.fragment_back_close);
		transaction.replace(R.id.context,arg);
		transaction.addToBackStack(null);
		transaction.commit();
//		manager.show(arg);
	}
	
//	/**
//	 * ִ����Ӳ���
//	 */
//	@Override
//	public void commit() {
//		// TODO �Զ����ɵķ������
//		manager.add();
//	}
	
//	/**
//	 * ����fragmentmanager
//	 */
//	@Override
	public void setManager(FragmentManager arg) {
		// TODO �Զ����ɵķ������
		this.manager = arg;
//		manager = new MfragmentManager(arg);
	}

	@Override
	public void goHome() {
		// TODO �Զ����ɵķ������
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
	 * ��ʾ��һ��fragment
	 */
	@Override
	public void goBack() {
		// TODO �Զ����ɵķ������
		manager.popBackStack();
	}

	@Override
	public void setMessage(String result) {
		// TODO �Զ����ɵķ������
		this.result = result;
	}

	@Override
	public String getMessage() {
		// TODO �Զ����ɵķ������
		if (result !=null) {
			return result;
		}
		return null;
	}

	@Override
	public void setBitMap(Bitmap bitmap) {
		// TODO �Զ����ɵķ������
		this.bitmap = bitmap;
	}

	@Override
	public Bitmap getBitmap() {
		// TODO �Զ����ɵķ������
		if (bitmap !=null) {
			return bitmap;
		}
		return null;
	}
//	/**
//	 * ��ʾ��һ��fragment
//	 */
//	@Override
//	public void next(int arg) {
//		// TODO �Զ����ɵķ������
//		manager.next(arg);
//	}
//
//	@Override
//	public boolean canGoBack() {
//		// TODO �Զ����ɵķ������
//		return manager.canGoBack();
//	}
}
