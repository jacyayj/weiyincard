package com.example.weiyin.utils;

import com.example.weiyin.card.R;
import com.example.weiyin.dao.HttpHelper;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class HttpUtil {
	
	private String url = null;
	private RequestParams params = null;
	private HttpHelper helper = null;
	private HttpHandler<String> utils = null;
	
	public HttpUtil(String url,HttpHelper helper) {
		// TODO 自动生成的构造函数存根
		this.url = url;
		this.helper = helper;
		params = new RequestParams("UTF-8");
	}
	
	public void setParams(String key,String value){
		params.addBodyParameter(key, value);
	}
	
	public void startHttpRequest() {
		// TODO 自动生成的方法存根
		utils = new HttpUtils().send(HttpMethod.POST, url, params, new RequestCallBack<String>() {
			
			@Override
			public void onStart() {
				// TODO 自动生成的方法存根
				helper.onStart();
				super.onStart();
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				// TODO 自动生成的方法存根
				helper.onFail(arg0.getMessage(),arg0.getExceptionCode(),arg1);
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				// TODO 自动生成的方法存根
				helper.onSuccess(arg0.result);
			}
		});
	}
	public void onCencle() {
		// TODO 自动生成的方法存根
		if (utils != null) {
			utils.cancel();
			helper.onCencle();
		}else {
			helper.onCencle(R.string.nodown);
		}
	}
}
