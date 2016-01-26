package com.example.weiyin.patterns;

public class ItemSource {
	private int icon = 0;
	private int background = 0;
	private String lable = null;
	private String describe = null;
	private String integral = null;
	private String remark = null;
	
	public ItemSource(int icon,int background,String lable,String describe,String integral) {
		// TODO 自动生成的构造函数存根
		this.icon = icon;
		this.background = background;
		this.lable = lable;
		this.describe = describe;
		this.integral = integral;
	}
	
	public ItemSource(int icon,String lable){
		this.icon = icon;
		this.lable = lable;
	}
	
	public ItemSource(String lable,String remark) {
		// TODO 自动生成的构造函数存根
		this.lable = lable;
		this.remark = remark;
	}
	
	public ItemSource(int icon,String lable,String describe) {
		// TODO 自动生成的构造函数存根
		setIcon(icon);
		setLable(lable);
		setDescribe(describe);
	}
	
	public ItemSource(int icon,String lable,String describe,String remark) {
		// TODO 自动生成的构造函数存根
		this.icon = icon;
		this.lable = lable;
		this.describe = describe;
		this.remark = remark;
	}
	
	public int getIcon() {
		return icon;
	}
	
	public void setIcon(int icon) {
		this.icon = icon;
	}
	
	public String getLable() {
		return lable;
	}
	
	public void setLable(String lable) {
		this.lable = lable;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public String getIntegral() {
		return integral;
	}
	
	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public int getBackground() {
		return background;
	}

	public void setBackground(int background) {
		this.background = background;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
