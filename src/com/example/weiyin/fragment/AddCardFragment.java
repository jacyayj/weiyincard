package com.example.weiyin.fragment;

import java.io.File;
import java.util.ArrayList;

import com.example.weiyin.adapter.FreeCardAdapter;
import com.example.weiyin.adapter.GeneralPagerAdapter;
import com.example.weiyin.card.R;
import com.example.weiyin.dao.FragmentListener;
import com.example.weiyin.operation.EditTextSearchListener;
import com.example.weiyin.operation.FragmentListenerImpl;
import com.example.weiyin.patterns.ItemSource;
import com.example.weiyin.patterns.Params;
import com.example.weiyin.utils.ContextUtli;
import com.example.weiyin.view.ActionSheetDialog;
import com.example.weiyin.view.ActionSheetDialog.OnSheetItemClickListener;
import com.example.weiyin.view.ActionSheetDialog.SheetItemColor;
import com.example.weiyin.zxing.CaptureActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
public class AddCardFragment extends Fragment  implements OnPageChangeListener{
	
	private View rootView = null;
	private View hadcardView = null;
	private View freecardView = null;
	
	private String result = null;
	private FragmentListener fragmentListener = null;
	private File file = null;
	private int flag = 1;
	private Bitmap cardfront = null;
	private Bitmap cardverso = null;
	
	@ViewInject(R.id.addcard_vip)
	private ViewPager pager = null;
	@ViewInject(R.id.addcard_menu)
	private View menu = null;
	private ArrayList<View>list = null;
	
	private EditText cardno = null;
	private Button cardbtn = null;
	private ImageView front = null;
	private ImageView verso = null;
	
	private ListView listView = null;
	private ArrayList<ItemSource> data = null;
	private ArrayList<ItemSource> searchlist = null;
	private FreeCardAdapter adapter = null;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		System.out.println("onCreateView2");
		rootView = inflater.inflate(R.layout.fragment_addcard, container, false);
		ViewUtils.inject(this, rootView);
		init();
		return rootView;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		System.out.println("onCreate2");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		// TODO 自动生成的方法存根
		System.out.println("onDestroy2");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO 自动生成的方法存根
		System.out.println("onDestroyView2");
		super.onDestroyView();
	}

	@Override
	public void onPause() {
		// TODO 自动生成的方法存根
		System.out.println("onPause2");
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		System.out.println("onResume2");
		super.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO 自动生成的方法存根
		System.out.println("onSaveInstanceState2");
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onStart() {
		// TODO 自动生成的方法存根
		System.out.println("onStart2");
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO 自动生成的方法存根
		System.out.println("onStop2");
		super.onStop();
	}
	private void init() {
		// TODO 自动生成的方法存根
		fragmentListener = FragmentListenerImpl.getInstance();
		
		hadcardView = getActivity().getLayoutInflater().inflate(R.layout.hadcard,null);
		freecardView = getActivity().getLayoutInflater().inflate(R.layout.freecard,null);
		
		creatHadCard();
		creatFreeCard();
		
		list = new ArrayList<View>();
		list.add(hadcardView);
		list.add(freecardView);
		
		pager.setAdapter(new GeneralPagerAdapter(list));
		pager.setOnPageChangeListener(this);
	}
	
	@OnClick({R.id.addcard_back,R.id.addcard_menu1,R.id.addcard_menu2,R.id.addcard_finish})
	private void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.addcard_back : fragmentListener.goBack();
			
			break;
		case R.id.addcard_menu1 : pager.setCurrentItem(0);
		
			break;
		case R.id.addcard_menu2 : pager.setCurrentItem(1);
		
			break;
		case R.id.addcard_finish : Toast.makeText(getActivity(),"完成",Toast.LENGTH_SHORT).show();
		
			break;
		default:
			break;
		}
	}
	
	private void creatHadCard() {
		// TODO 自动生成的方法存根
		cardno = (EditText) hadcardView.findViewById(R.id.card_no);
		cardbtn = (Button) hadcardView.findViewById(R.id.card_btn);
		front = (ImageView) hadcardView.findViewById(R.id.take_front);
		verso = (ImageView) hadcardView.findViewById(R.id.take_verso);
		
		OnClickListener clickListener = new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				switch (arg0.getId()) {
				case R.id.take_front : flag = 1;takeCardPhoto();
					
					break;
				case R.id.take_verso : flag = 2;takeCardPhoto();
				
					break;
				case R.id.card_btn : startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
				
				break;
				default:
					break;
				}
			}
		};
		front.setOnClickListener(clickListener);
		verso.setOnClickListener(clickListener);
		cardbtn.setOnClickListener(clickListener);
	}
	
	private void creatFreeCard() {
		// TODO 自动生成的方法存根
		listView = (ListView) freecardView.findViewById(R.id.free_card_listview);
		data = new ArrayList<ItemSource>();
		ItemSource source = new ItemSource(R.drawable.icon_dicos, R.drawable.item_bg2,"德克士", "fgasfdfafasfas",null);
		ItemSource source2 = new ItemSource(R.drawable.icon_dq, R.drawable.item_bg1,"DQ", "fgasfdfafasfas",null);
		ItemSource source3 = new ItemSource(R.drawable.icon_startbucks, R.drawable.item_bg3,"星巴克", "fgasfdfafasfas",null);
		data.add(source);
		data.add(source2);
		data.add(source3);
		
		adapter = new FreeCardAdapter(getActivity());
		listView.setAdapter(adapter);
		adapter.refresh(data);
		
		EditText search = (EditText) freecardView.findViewById(R.id.addcard_search);
		search.addTextChangedListener(new EditTextSearchListener(adapter, data,Params.flag.FREECARD_FLAG));
		
	}
	
	 public void searched(String lable) {
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
	
	@SuppressWarnings("deprecation")
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		switch (requestCode) {
		case 0 :
			if (resultCode == Activity.RESULT_OK) {
			result = data.getStringExtra("result");
			cardno.setText(result);
			}
			break;
		case 1 :  
			if (resultCode == Activity.RESULT_OK) {
					 switch (flag) {
		        		case 1 : file = new File(Environment.getExternalStorageDirectory()+ "/cardfront.jpg");
		        			break;
		        		case 2 : file = new File(Environment.getExternalStorageDirectory()+ "/cardverso.jpg");
		        			break;
		        			default : break;
		        		}
					 cropPhoto(Uri.fromFile(file));//裁剪图片
            }
			break;
		case 2 :
			if (resultCode == Activity.RESULT_OK) {
                cropPhoto(data.getData());//裁剪图片
            }
			break;
		case 3 :
	         if (data != null) {
	                Bundle extras = data.getExtras();
	                	switch (flag) {
	    				case 1 : cardfront = extras.getParcelable("data");
	    						 if(cardfront!=null ){
	    						 ContextUtli.setPicToView(cardfront, "cardfront.jpg");//保存在SD卡中
	                			 front.setBackgroundDrawable(new BitmapDrawable(cardfront));
	    						}
	    					break;
	    				case 2 : cardverso = extras.getParcelable("data");
	    						 if(cardverso!=null ){
	    						 ContextUtli.setPicToView(cardverso, "cardverso.jpg");//保存在SD卡中
			        			 verso.setBackgroundDrawable(new BitmapDrawable(cardverso));//用ImageView显示出来
	    						}
	    					break;
		       			default : break;
	    				}
	                    if (file!=null) {
	                   	 file.delete();
	           		}
	            }
			break;
		default:
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	private void takeCardPhoto() {
		// TODO 自动生成的方法存根

		new ActionSheetDialog(getActivity())
		.builder()
		.setCancelable(true)
		.setCanceledOnTouchOutside(true)
		.addSheetItem("拍照", SheetItemColor.Red,
				new OnSheetItemClickListener() {
					@Override
					public void onClick(int which) {
						Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
						 switch (flag) {
			        		case 1 : intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
		                            "cardfront.jpg")));
			        		System.out.println("flag"+flag);
			        			break;
			        		case 2 : intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
		                            "cardverso.jpg")));
			        		System.out.println("flag"+flag);
			        			break;
			        			default : break; 
			        		}
							 startActivityForResult(intent2, 1);//采用ForResult打开
						}
				})
			.addSheetItem("选择照片", SheetItemColor.Red, new OnSheetItemClickListener() {
					
					@Override
					public void onClick(int which) {
						// TODO 自动生成的方法存根
						Intent intent1 = new Intent(Intent.ACTION_PICK, null);
			            intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			            startActivityForResult(intent1, 2);
					}
				}).show();
	
	}
	
    /**
     * 调用系统的裁剪
     * @param uri 图片路径
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
         // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 2);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 500);
        intent.putExtra("outputY", 250);
        intent.putExtra("return-data", true);
        intent.putExtra("scale", true);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", true); // no face detection
        startActivityForResult(intent, 3);
    }
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO 自动生成的方法存根
		menu.setBackgroundResource(R.drawable.addcard_menu1+arg0);
	}

}
