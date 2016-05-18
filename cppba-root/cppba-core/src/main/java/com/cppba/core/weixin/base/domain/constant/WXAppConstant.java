package com.cppba.core.weixin.base.domain.constant;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXAppConstant {
    public String TOKEN = "";
    public String APP_ID = "";
    public String APP_SECRET = "";
    public String EncodingAESKey = "";

    public WXAppConstant(String appId, String appSecret, String appToken, String encodingAESKey) {
        APP_ID = appId;
        APP_SECRET = appSecret;
        TOKEN = appToken;
        EncodingAESKey = encodingAESKey;
    }
}
