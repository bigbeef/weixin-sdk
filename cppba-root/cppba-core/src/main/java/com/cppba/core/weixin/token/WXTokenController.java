package com.cppba.core.weixin.token;

import java.util.Date;

import com.cppba.core.weixin.WXApi;
import com.cppba.core.weixin.base.WXHttpDispatch;
import com.cppba.core.weixin.base.domain.constant.WXAppConstant;
import com.cppba.core.weixin.base.exception.WXException;
import com.cppba.core.weixin.token.request.WXTokenRequest;
import com.cppba.core.weixin.token.response.WXTokenResponse;

import lombok.Data;

public class WXTokenController {

	private static WXApi wxapi = null;
	
	public WXTokenController(WXApi wxapi){
		this.wxapi = wxapi;
	}
	
	private static AccessToken accessToken;

    public synchronized static void parseAndStoreAccessToken() throws WXException {
        if (!isTokenAvailable()) {
            //get access token.
            WXTokenRequest request = new WXTokenRequest(wxapi.getWxAppConstant().APP_ID, wxapi.getWxAppConstant().APP_SECRET);
            WXTokenResponse response = (WXTokenResponse) WXHttpDispatch.execute(request);
            //store
            accessToken = new AccessToken();
            accessToken.setAccess_token(response.getAccessToken());
            accessToken.setExpires_in(response.getExpires());
            accessToken.setCreateDate(new Date());
            System.out.println(String.format("refresh access token:{value:%s,expires_in:%d}", accessToken.access_token, accessToken.expires_in));
        }
    }

    public static boolean isTokenAvailable() {
        return (accessToken != null && !accessToken.isExpired());
    }

    public static String getToken() throws WXException {
        if (!isTokenAvailable()) {
            parseAndStoreAccessToken();
        }
        return accessToken.getAccess_token();
    }
	
    @Data
	private static class AccessToken {
		private String access_token;
		private long expires_in;
		private Date createDate;

		public boolean isExpired() {
			// To make sure the token is available,
			// invalid the token 5 minutes in advance;
			Date date = new Date();
			long remainingTime = createDate.getTime() + expires_in * 1000 - date.getTime();
			long seconds = remainingTime / 1000;
			return seconds < 5 * 60;
		}

		public String getAccess_token() {
			return access_token;
		}

		public void setAccess_token(String access_token) {
			this.access_token = access_token;
		}

		public long getExpires_in() {
			return expires_in;
		}

		public void setExpires_in(long expires_in) {
			this.expires_in = expires_in;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
	}
}
