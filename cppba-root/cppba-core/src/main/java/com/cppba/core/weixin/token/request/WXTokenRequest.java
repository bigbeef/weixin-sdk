package com.cppba.core.weixin.token.request;

import com.cppba.core.weixin.base.exception.WXException;
import com.cppba.core.weixin.base.request.WXRequest;
import com.cppba.core.weixin.token.response.WXTokenResponse;
import com.cppba.core.weixin.util.WXJsonUtil;

/**
 * http请求方式: GET
 * Created by lemon_bar on 15/7/7.
 */
public class WXTokenRequest extends WXRequest<WXTokenResponse> {

    private final static String GRANT_TYPE_DEFAULT = "client_credential";

    public WXTokenRequest(String appId, String appSecret) {
        super();
        this.path = "/cgi-bin/token";
        this.addParameter("grant_type", GRANT_TYPE_DEFAULT);
        this.addParameter("appid", appId);
        this.addParameter("secret", appSecret);
        //https://api.weixin.qq.com/cgi-bin/token
        //?grant_type=client_credential
        //&appid=APPID
        //&secret=APPSECRET
    }

    @Override
    public WXTokenResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXTokenResponse.class);
    }
}
