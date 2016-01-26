package com.example.weiyin.operation;


import com.example.weiyin.fragment.AddCardFragment;
import com.example.weiyin.fragment.EditPersonalDetailsFragment;
import com.example.weiyin.fragment.FindPassWordFragment;
import com.example.weiyin.fragment.LoginFragment;
import com.example.weiyin.fragment.MainFragment;
import com.example.weiyin.fragment.RegFragment;
import com.example.weiyin.fragment.SetPassWordFragment;
import com.example.weiyin.fragment.VipIntroduceFragment;

	/**
	 * fragment管理类
	 * @author jacyayj
	 */
public class MfragmentManager {
	
	public void setMAIN_FRAGMENT() {
		MAIN_FRAGMENT = new  MainFragment();
	}

	public void setADD_CARD_FRAGMENT() {
		ADD_CARD_FRAGMENT = new AddCardFragment();
	}

	public void setDETAILS_FRAGMENT() {
		DETAILS_FRAGMENT = new EditPersonalDetailsFragment();
	}

	public void setLOGIN_FRAGMENT() {
		LOGIN_FRAGMENT = new LoginFragment();
	}

	public void setREG_FRAGMENT() {
		REG_FRAGMENT = new RegFragment();
	}

	public void setFIND_PASS_WORD_FRAGMENT() {
		FIND_PASS_WORD_FRAGMENT = new FindPassWordFragment();
	}

	public void setSET_PASS_WORD_FRAGMENT() {
		SET_PASS_WORD_FRAGMENT = new SetPassWordFragment();
	}

	public void setVIP_INTRODUCE_FRAGMENT() {
		VIP_INTRODUCE_FRAGMENT = new VipIntroduceFragment();
	}
	private  MainFragment MAIN_FRAGMENT = null;
	private  AddCardFragment ADD_CARD_FRAGMENT = null;
	private  EditPersonalDetailsFragment DETAILS_FRAGMENT = null;
	private  LoginFragment LOGIN_FRAGMENT = null;
	private  RegFragment REG_FRAGMENT = null;
	private  FindPassWordFragment FIND_PASS_WORD_FRAGMENT = null;
	private  SetPassWordFragment SET_PASS_WORD_FRAGMENT = null;
	private  VipIntroduceFragment VIP_INTRODUCE_FRAGMENT = null;
	
//	private static MfragmentManager instance =  new MfragmentManager();
	
	private MfragmentManager() {
		// TODO 自动生成的构造函数存根
		setADD_CARD_FRAGMENT();
		setDETAILS_FRAGMENT();
		setFIND_PASS_WORD_FRAGMENT();
		setLOGIN_FRAGMENT();
		setMAIN_FRAGMENT();
		setREG_FRAGMENT();
		setSET_PASS_WORD_FRAGMENT();
		setVIP_INTRODUCE_FRAGMENT();
	}
	
//	public static MfragmentManager getInstance() {
//		return instance;
//	}
	
	public MainFragment getMAIN_FRAGMENT() {
		return MAIN_FRAGMENT;
	}
	public AddCardFragment getADD_CARD_FRAGMENT() {
		return ADD_CARD_FRAGMENT;
	}
	public EditPersonalDetailsFragment getDETAILS_FRAGMENT() {
		return DETAILS_FRAGMENT;
	}
	public LoginFragment getLOGIN_FRAGMENT() {
		return LOGIN_FRAGMENT;
	}
	public RegFragment getREG_FRAGMENT() {
		return REG_FRAGMENT;
	}
	public FindPassWordFragment getFIND_PASS_WORD_FRAGMENT() {
		return FIND_PASS_WORD_FRAGMENT;
	}
	public SetPassWordFragment getSET_PASS_WORD_FRAGMENT() {
		return SET_PASS_WORD_FRAGMENT;
	}
	public VipIntroduceFragment getVIP_INTRODUCE_FRAGMENT() {
		return VIP_INTRODUCE_FRAGMENT;
	}
}
