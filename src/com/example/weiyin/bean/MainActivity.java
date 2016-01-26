package com.example.weiyin.bean;


import com.example.weiyin.card.R;
import com.example.weiyin.dao.FragmentListener;
import com.example.weiyin.fragment.AddCardFragment;
import com.example.weiyin.fragment.MainFragment;
import com.example.weiyin.operation.FragmentListenerImpl;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
	/**
	 * 程序入口、主界面
	 * @author jacyayj
	 *
	 */
public class MainActivity extends FragmentActivity{
	
	private FragmentListener fragmentListener = null;
	private FragmentManager manager = null;
	
	private boolean isFrist = false;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		overridePendingTransition(R.anim.fragment_open, R.anim.fragment_close);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (savedInstanceState == null) {
        		manager.beginTransaction().add(R.id.context,new MainFragment()).addToBackStack(null).commit();
        	if (isFrist) {
    			fragmentListener.show(new AddCardFragment());
        	}
		}
    }

    private void init() {
		// TODO 自动生成的方法存根
    	fragmentListener = FragmentListenerImpl.getInstance();
    	manager = getSupportFragmentManager();
    	fragmentListener.setManager(manager);
	}
    
    @Override
    public void onBackPressed() {
    	System.out.println(manager.getBackStackEntryCount());
    	if (manager.getBackStackEntryCount() == 1) {
    		new AlertDialog.Builder(this)
        	.setTitle(R.string.exit)
        	.setMessage(R.string.exit_messge)
        	.setNegativeButton(R.string.confirm,new OnClickListener() {
    			@Override
    			public void onClick(DialogInterface arg0, int arg1) {
    				// TODO 自动生成的方法存根 
    				finish();
    			}
    		})
    		.setPositiveButton(R.string.cencle,null)
    		.create()
    		.show();
        }else {
        	manager.popBackStack();
    		}
		}
}