package com.cppba.core.weixin;

import com.cppba.core.weixin.base.domain.constant.WXAppConstant;

import lombok.Getter;

@Getter
public class WXApi {
	
	private WXAppConstant wxAppConstant = null;
	
	public WXApi(String appId, String appSecret, String appToken, String encodingAESKey) {
		wxAppConstant = new WXAppConstant(appId, appSecret, appToken, encodingAESKey);
    }
	
	
	public String getAccessToken(){
		return null;
	}
}
