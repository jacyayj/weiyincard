package com.example.weiyin.fragment;

import java.util.ArrayList;

import com.example.weiyin.adapter.CardBagAdapter;
import com.example.weiyin.adapter.CouPonAdapter;
import com.example.weiyin.adapter.GeneralPagerAdapter;
import com.example.weiyin.adapter.MineAdapter;
import com.example.weiyin.card.R;
import com.example.weiyin.dao.FragmentListener;
import com.example.weiyin.operation.EditTextSearchListener;
import com.example.weiyin.operation.FragmentListenerImpl;
import com.example.weiyin.patterns.ItemSource;
import com.example.weiyin.patterns.Params;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.AbsListView.LayoutParams;

public class MainFragment extends Fragment implements OnPageChangeListener{
	private View cardbagView = null;
	private View couponView = null;
	private View mineView = null;
	
	@ViewInject(R.id.menu)
	private View menu = null;
	@ViewInject(R.id.viewpager)
	private ViewPager pager = null;
	private View rootView = null;
	private FragmentListener fragmentListener = null;
	@ViewInject(R.id.title)
	private TextView title = null;
	
	private View footview = null;
	private ListView cardbaglistView = null;
	private ArrayList<View> pagerlist = null;
	
	private ListView couponlistview = null;
	private CouPonAdapter couPonAdapter = null;
	private ViewPager couponpager = null;
	private ImageView [] dots = null;
	private View couponmenu = null;
	
	private MineAdapter mineAdapter = null;
	private Button loginButton = null;
	private ImageView mineiconView = null;
	private TextView nicknameView = null;
	private TextView idView = null;
	private ListView mineListView = null;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("onCreateView1");
		// TODO 自动生成的方法存根
		rootView = inflater.inflate(R.layout.fragment_main, container, false);
		fragmentListener = FragmentListenerImpl.getInstance();
		ViewUtils.inject(this,rootView);
		init();
		return rootView;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		System.out.println("onCreate1");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		// TODO 自动生成的方法存根
		System.out.println("onDestroy1");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO 自动生成的方法存根
		System.out.println("onDestroyView1");
		super.onDestroyView();
	}

	@Override
	public void onPause() {
		// TODO 自动生成的方法存根
		System.out.println("onPause1");
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		System.out.println("onResume1");
		super.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO 自动生成的方法存根
		System.out.println("onSaveInstanceState1");
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onStart() {
		// TODO 自动生成的方法存根
		System.out.println("onStart1");
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO 自动生成的方法存根
		System.out.println("onStop1");
		super.onStop();
	}

	private void init() {
		// TODO 自动生成的方法存根
		cardbagView = getActivity().getLayoutInflater().inflate(R.layout.card_bag, null);
		couponView = getActivity().getLayoutInflater().inflate(R.layout.coupon, null);
		mineView = getActivity().getLayoutInflater().inflate(R.layout.mine, null);
		footview = getActivity().getLayoutInflater().inflate(R.layout.foot_layout, null);
		
		cardBagCreat();
		couponCreat();
		minCreat();
		
		pagerlist = new ArrayList<View>();
    	pagerlist.add(cardbagView);
    	pagerlist.add(couponView);
    	pagerlist.add(mineView);
    	
    	pager.setAdapter(new GeneralPagerAdapter(pagerlist));
    	pager.setOnPageChangeListener(this);
    	pager.setVerticalScrollBarEnabled(true);
		pager.setKeepScreenOn(true);
	}
	
	@SuppressWarnings("deprecation")
	private void cardBagCreat() {
		// TODO 自动生成的方法存根
				//初始化页面数据
				cardbaglistView = (ListView) cardbagView.findViewById(R.id.card_bag_list);
				final ArrayList<ItemSource> data = new ArrayList<ItemSource>();
				ItemSource source = new ItemSource(R.drawable.icon_dicos, R.drawable.item_bg2,"德克士", "fgasfdfafasfas","100");
				ItemSource source2 = new ItemSource(R.drawable.icon_dq, R.drawable.item_bg1,"DQ", "fgasfdfafasfas","100");
				ItemSource source3 = new ItemSource(R.drawable.icon_startbucks, R.drawable.item_bg3,"星巴克", "fgasfdfafasfas","100");
				data.add(source);
				data.add(source2);
				data.add(source3);
				
				//设置listviewadapter并更新界面
				CardBagAdapter adapter = new CardBagAdapter(getActivity());
				cardbaglistView.setAdapter(adapter);
				adapter.refresh(data);
				
				LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,(int)(getActivity().getWindowManager().getDefaultDisplay().getHeight()*0.13));
				footview.setLayoutParams(params);
				cardbaglistView.addFooterView(footview);
				
				cardbaglistView.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO 自动生成的方法存根
						Toast.makeText(getActivity(), "点击"+arg2, Toast.LENGTH_SHORT).show();
						fragmentListener.setMessage(data.get(arg2).getLable());
						fragmentListener.show(new VipIntroduceFragment());
						if (arg2 == data.size()) {
							fragmentListener.show(new AddCardFragment());
						}
					}
				});
	}
	
	private void couponCreat() {
		// TODO 自动生成的方法存根
		couponlistview = (ListView) couponView.findViewById(R.id.coupon_listview);
		couponmenu = couponView.findViewById(R.id.coupon_menu);
		
		ArrayList<ItemSource>data = new ArrayList<ItemSource>();
		ItemSource source = new ItemSource(R.drawable.icon_watsons, "屈臣氏", "dasdsadsada", "还有一天开始");
		ItemSource source2 = new ItemSource(R.drawable.icon_dq, "DQ", "dasdsadsada", "还有一天开始");
		ItemSource source3 = new ItemSource(R.drawable.icon_dicos, "德克士", "dasdsadsada", "还有一天开始");
		data.add(source);
		data.add(source2);
		data.add(source3);
		data.add(source3);
		data.add(source3);
		couPonAdapter = new CouPonAdapter(getActivity());
		couponlistview.setAdapter(couPonAdapter); 
		couPonAdapter.refresh(data);
		couponlistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO 自动生成的方法存根
				fragmentListener.show(new ActivityDetailsFragment());
			}
		});
		
		EditText couponsearch = (EditText) couponView.findViewById(R.id.coupon_search);
		TextWatcher watcher = new EditTextSearchListener(couPonAdapter, data, Params.flag.COUPON_FLAG);
		couponsearch.addTextChangedListener(watcher);
		
		couponpager = (ViewPager) couponView.findViewById(R.id.coupon_vip);
		dots = new ImageView[3];
		dots[0] = (ImageView) couponView.findViewById(R.id.coupon_dot1);
		dots[1] = (ImageView) couponView.findViewById(R.id.coupon_dot2);
		dots[2] = (ImageView) couponView.findViewById(R.id.coupon_dot3);
		
		final ArrayList<View> postrts = new ArrayList<View>();
		ViewGroup group = (ViewGroup) getActivity().getLayoutInflater().inflate(R.layout.coupon_postrt, null);
		postrts.add(group.findViewById(R.id.coupon_poster1));
		postrts.add(group.findViewById(R.id.coupon_poster2));
		postrts.add(group.findViewById(R.id.coupon_poster3));
		group.removeAllViews();
		couponpager.setAdapter(new GeneralPagerAdapter(postrts));
		couponpager.setVerticalScrollBarEnabled(true);
		couponpager.setKeepScreenOn(true);
		couponpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO 自动生成的方法存根
				for (int i = 0; i < postrts.size(); i++) {
					if (i == arg0) {
						dots[i].setImageResource(R.drawable.coupon_dot_a);
					}else {
						dots[i].setImageResource(R.drawable.coupon_dot_b);
					}
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO 自动生成的方法存根
				System.out.println(arg1);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO 自动生成的方法存根
			}
		});
		
		ImageButton menu1 = (ImageButton) couponView.findViewById(R.id.coupon_menu1);
		ImageButton menu2 = (ImageButton) couponView.findViewById(R.id.coupon_menu2);
		
		OnClickListener clickListener = new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				switch (arg0.getId()) {
				case R.id.coupon_menu1 : couponmenu.setBackgroundResource(R.drawable.coupon_menu1);
				  break;
				case R.id.coupon_menu2 : couponmenu.setBackgroundResource(R.drawable.coupon_menu2);
				default:
				break;
				}
			}
		};
		menu1.setOnClickListener(clickListener);
		menu2.setOnClickListener(clickListener);
	}
	
	private void minCreat() {
		// TODO 自动生成的方法存根
		mineiconView = (ImageView) mineView.findViewById(R.id.mine_icon);
		nicknameView = (TextView) mineView.findViewById(R.id.mine_nickname);
		idView = (TextView) mineView.findViewById(R.id.mine_id);
		mineListView = (ListView) mineView.findViewById(R.id.mine_listview);
		loginButton = (Button) mineView.findViewById(R.id.login);
		ArrayList<ItemSource>data = new ArrayList<ItemSource>();
		
		if (fragmentListener.getBitmap()!=null) {
			mineiconView.setImageBitmap(fragmentListener.getBitmap());
		}
		if (fragmentListener.getMessage()!=null) {         
			nicknameView.setText("ID："+fragmentListener.getMessage());
		}
		
		nicknameView.append("咩咩咩");
		idView.append("9876543210");
		for (int i = 0; i < getResources().getStringArray(R.array.mine_lable_array).length; i++) {
			
			data.add(new ItemSource(R.drawable.mine_icon_2+i,getResources().getStringArray(R.array.mine_lable_array)[i]));
		}
		
		OnClickListener clickListener = new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				switch (arg0.getId()) {
				case R.id.mine_icon : fragmentListener.show(new EditPersonalDetailsFragment());
					
					break;
				case R.id.login : fragmentListener.show(new LoginFragment());
				
					break;
				default:
					break;
				}
			}
		};
		loginButton.setOnClickListener(clickListener);
		mineiconView.setOnClickListener(clickListener);
		
		mineAdapter = new MineAdapter(getActivity());
		mineListView.setAdapter(mineAdapter);
		mineAdapter.refresh(data);
		mineListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO 自动生成的方法存根
				switch (arg2) {
				case 0 : fragmentListener.show(new MyCouponFragment());
					
					break;
				case 1 : fragmentListener.show(new NewsFragment());
				
				break;
				case 2 : fragmentListener.show(new FeedBackFragment());
				
				break;
				case 3 : fragmentListener.show(new AboutUsFragment());
				
				break;
				default:
					break;
				}
			}
		});
	}
	
    /**
     * 处理页面点击事件
     * @param v 被点击的控件
     */
    @OnClick({R.id.menu1,R.id.menu2,R.id.menu3,R.id.addcard_btn})
    private void onClick(View v) {
		// TODO 自动生成的方法存根
    	switch (v.getId()) {
		case R.id.menu1 : menu.setBackgroundResource(R.drawable.menu1);
									   pager.setCurrentItem(0);
			break;
		case R.id.menu2 : menu.setBackgroundResource(R.drawable.menu2);
									   pager.setCurrentItem(1);
			break;
		case R.id.menu3 : menu.setBackgroundResource(R.drawable.menu3);
									   pager.setCurrentItem(2);
			break;
		case R.id.addcard_btn : fragmentListener.show(new AddCardFragment());
		Toast.makeText(getActivity(), "点击", Toast.LENGTH_SHORT).show();
		default:
			break;
		}
	}
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO 自动生成的方法存根
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO 自动生成的方法存根
//		Log.d("jacy", arg0+":"+arg1+":"+arg2);
	}
	
	@Override
	public void onPageSelected(int arg0) {
		// TODO 自动生成的方法存根
		menu.setBackgroundResource(R.drawable.menu1+arg0);
		switch (arg0) {
		case 0 : title.setText(R.string.card_bag);
			
			break;
		case 1 : title.setText(R.string.coupon);
		
			break;
		case 2 : title.setText(R.string.mine);
		
			break;
		default:
			break;
		}
	}
}
