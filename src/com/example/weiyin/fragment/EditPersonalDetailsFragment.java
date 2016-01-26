package com.example.weiyin.fragment;

import java.io.File;
import java.util.ArrayList;

import com.example.weiyin.card.R;
import com.example.weiyin.dao.FragmentListener;
import com.example.weiyin.operation.FragmentListenerImpl;
import com.example.weiyin.utils.ContextUtli;
import com.example.weiyin.view.ActionSheetDialog;
import com.example.weiyin.view.ActionSheetDialog.OnSheetItemClickListener;
import com.example.weiyin.view.ActionSheetDialog.SheetItemColor;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditPersonalDetailsFragment extends Fragment implements OnCheckedChangeListener{
	@ViewInject(R.id.edit_text1)
	private EditText text1 = null;
	@ViewInject(R.id.edit_text2)
	private EditText text2 = null;
	@ViewInject(R.id.edit_text3)
	private EditText text3 = null;
	@ViewInject(R.id.edit_text4)
	private TextView text4 = null;
	@ViewInject(R.id.edit_text5)
	private EditText text5 = null;
	@ViewInject(R.id.edit_manbox)
	private CheckBox box1 = null;
	@ViewInject(R.id.edit_womanbox)
	private CheckBox box2 = null;
	@ViewInject(R.id.edit_icon)
	private ImageView head = null;
	
	private View rootView = null;
	
	private ArrayList<String> data = null;
	private AlertDialog.Builder datepickerdialog = null;
	private DatePicker picker = null;
	private File file = null;
	private Bitmap headicon = null;
	
	private FragmentListener fragmentListener = null;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		rootView = inflater.inflate(R.layout.fragment_personaldetails, container, false);
		ViewUtils.inject(this, rootView);
		init();
		return rootView;
	}
	
	private void init() {
		// TODO 自动生成的方法存根
		fragmentListener = FragmentListenerImpl.getInstance();
		data = new ArrayList<String>();
		data.add("9876543210");
		data.add("咩咩咩");
		data.add("杨杨杨");
		data.add("9876543210@weiyin.com");
		EditText editTexts[] = new EditText[]{text1,text2,text3,text5};
		for (int i = 0; i < editTexts.length; i++) {
			editTexts[i].setText(data.get(i));
		}
		box1.setOnCheckedChangeListener(this);
		box2.setOnCheckedChangeListener(this);
	}
	
	@OnClick({R.id.edit_birthday,R.id.edit_back,R.id.edit_womanbox,R.id.edit_icon,R.id.edit_save})
	private void onClick(View view) {
		// TODO 自动生成的方法存根
		switch (view.getId()) {
		case R.id.edit_birthday : creatDataPicker(); 
			
			break;
		case R.id.edit_back : getActivity().onBackPressed();
		
			break;
		case R.id.edit_icon : editHeadIcon();
		
			break;
		case R.id.edit_save : save();
			break;
		default:
			break;
		}
	}
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO 自动生成的方法存根
		if (arg0.getId() == box1.getId()) {
			if (arg1) {
				box2.setChecked(false);
			}else {
				box2.setChecked(true);
			}
		}else {
			if (arg1) {
				box1.setChecked(false);
			}else {
				box1.setChecked(true);
			}
		}
	}
	
	private void save() {
		// TODO 自动生成的方法存根
		fragmentListener.setBitMap(headicon);
		fragmentListener.setMessage(text2.getText().toString());
		getActivity().onBackPressed();
	}
	
	private void creatDataPicker() {
		// TODO 自动生成的方法存根
		datepickerdialog = new AlertDialog.Builder(getActivity());
		View view = getActivity().getLayoutInflater().inflate(R.layout.date_picker, null);
		picker = (DatePicker) view.findViewById(R.id.datepicker);
		datepickerdialog.setView(view);
		datepickerdialog.setNegativeButton(R.string.confirm, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO 自动生成的方法存根
				text4.setText(picker.getYear()+"-"+(picker.getMonth()+1)+"-"+picker.getDayOfMonth());
			}
		});
		datepickerdialog.setPositiveButton(R.string.cencle, null);
		datepickerdialog.create().show();
	}
	
	private void editHeadIcon(){
		new ActionSheetDialog(getActivity())
		.builder()
		.addSheetItem("拍照",SheetItemColor.Red ,new OnSheetItemClickListener() {
			
			@Override
			public void onClick(int which) {
				// TODO 自动生成的方法存根
				Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"headicon.jpg")));
				startActivityForResult(intent2, 1);
			}
		})
		.addSheetItem("选取照片", SheetItemColor.Red,new OnSheetItemClickListener() {
			
			@Override
			public void onClick(int which) {
				// TODO 自动生成的方法存根
				Intent intent1 = new Intent(Intent.ACTION_PICK, null);
	            intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
	            startActivityForResult(intent1, 2);
			}
		})
		.show();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		switch (requestCode) {
		case 1 : 
			if (resultCode == Activity.RESULT_OK) {
				file = new File(Environment.getExternalStorageDirectory()+ "/headicon.jpg");
				cropPhoto(Uri.fromFile(file));
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
    				 headicon = extras.getParcelable("data");
    				 headicon = ContextUtli.toRoundBitmap(headicon);
    						 if(headicon!=null ){
    						 ContextUtli.setPicToView(headicon, "headicon.jpg");//保存在SD卡中
		        			 head.setBackgroundDrawable(new BitmapDrawable(headicon));//用ImageView显示出来
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
	
    /**
     * 调用系统的裁剪
     * @param uri 图片路径
     */
	
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
         // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        intent.putExtra("scale", true);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", true); // no face detection
        startActivityForResult(intent, 3);
    }
    
}
