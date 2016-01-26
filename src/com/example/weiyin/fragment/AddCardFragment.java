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
		// TODO �Զ����ɵķ������
		System.out.println("onCreateView2");
		rootView = inflater.inflate(R.layout.fragment_addcard, container, false);
		ViewUtils.inject(this, rootView);
		init();
		return rootView;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		System.out.println("onCreate2");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		// TODO �Զ����ɵķ������
		System.out.println("onDestroy2");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO �Զ����ɵķ������
		System.out.println("onDestroyView2");
		super.onDestroyView();
	}

	@Override
	public void onPause() {
		// TODO �Զ����ɵķ������
		System.out.println("onPause2");
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO �Զ����ɵķ������
		System.out.println("onResume2");
		super.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO �Զ����ɵķ������
		System.out.println("onSaveInstanceState2");
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onStart() {
		// TODO �Զ����ɵķ������
		System.out.println("onStart2");
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO �Զ����ɵķ������
		System.out.println("onStop2");
		super.onStop();
	}
	private void init() {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		switch (v.getId()) {
		case R.id.addcard_back : fragmentListener.goBack();
			
			break;
		case R.id.addcard_menu1 : pager.setCurrentItem(0);
		
			break;
		case R.id.addcard_menu2 : pager.setCurrentItem(1);
		
			break;
		case R.id.addcard_finish : Toast.makeText(getActivity(),"���",Toast.LENGTH_SHORT).show();
		
			break;
		default:
			break;
		}
	}
	
	private void creatHadCard() {
		// TODO �Զ����ɵķ������
		cardno = (EditText) hadcardView.findViewById(R.id.card_no);
		cardbtn = (Button) hadcardView.findViewById(R.id.card_btn);
		front = (ImageView) hadcardView.findViewById(R.id.take_front);
		verso = (ImageView) hadcardView.findViewById(R.id.take_verso);
		
		OnClickListener clickListener = new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		listView = (ListView) freecardView.findViewById(R.id.free_card_listview);
		data = new ArrayList<ItemSource>();
		ItemSource source = new ItemSource(R.drawable.icon_dicos, R.drawable.item_bg2,"�¿�ʿ", "fgasfdfafasfas",null);
		ItemSource source2 = new ItemSource(R.drawable.icon_dq, R.drawable.item_bg1,"DQ", "fgasfdfafasfas",null);
		ItemSource source3 = new ItemSource(R.drawable.icon_startbucks, R.drawable.item_bg3,"�ǰͿ�", "fgasfdfafasfas",null);
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
	            // ����ƥ�������  
	            if (index != -1) {  
	                searchlist.add(data.get(i));  
	                System.out.println(data.get(i).getLable());
	            }  
	        }  
	    }  
	
	@SuppressWarnings("deprecation")
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO �Զ����ɵķ������
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
					 cropPhoto(Uri.fromFile(file));//�ü�ͼƬ
            }
			break;
		case 2 :
			if (resultCode == Activity.RESULT_OK) {
                cropPhoto(data.getData());//�ü�ͼƬ
            }
			break;
		case 3 :
	         if (data != null) {
	                Bundle extras = data.getExtras();
	                	switch (flag) {
	    				case 1 : cardfront = extras.getParcelable("data");
	    						 if(cardfront!=null ){
	    						 ContextUtli.setPicToView(cardfront, "cardfront.jpg");//������SD����
	                			 front.setBackgroundDrawable(new BitmapDrawable(cardfront));
	    						}
	    					break;
	    				case 2 : cardverso = extras.getParcelable("data");
	    						 if(cardverso!=null ){
	    						 ContextUtli.setPicToView(cardverso, "cardverso.jpg");//������SD����
			        			 verso.setBackgroundDrawable(new BitmapDrawable(cardverso));//��ImageView��ʾ����
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
		// TODO �Զ����ɵķ������

		new ActionSheetDialog(getActivity())
		.builder()
		.setCancelable(true)
		.setCanceledOnTouchOutside(true)
		.addSheetItem("����", SheetItemColor.Red,
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
							 startActivityForResult(intent2, 1);//����ForResult��
						}
				})
			.addSheetItem("ѡ����Ƭ", SheetItemColor.Red, new OnSheetItemClickListener() {
					
					@Override
					public void onClick(int which) {
						// TODO �Զ����ɵķ������
						Intent intent1 = new Intent(Intent.ACTION_PICK, null);
			            intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			            startActivityForResult(intent1, 2);
					}
				}).show();
	
	}
	
    /**
     * ����ϵͳ�Ĳü�
     * @param uri ͼƬ·��
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
         // aspectX aspectY �ǿ�ߵı���
        intent.putExtra("aspectX", 2);
        intent.putExtra("aspectY", 1);
        // outputX outputY �ǲü�ͼƬ���
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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO �Զ����ɵķ������
		menu.setBackgroundResource(R.drawable.addcard_menu1+arg0);
	}

}
