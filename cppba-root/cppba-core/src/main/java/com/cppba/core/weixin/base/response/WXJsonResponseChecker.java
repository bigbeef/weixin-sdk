package com.cppba.core.weixin.base.response;

import com.cppba.core.weixin.base.exception.WXException;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXJsonResponseChecker {
    public static void check(WXJsonResponse wxJsonResponse) throws WXException {
        if (wxJsonResponse == null) {
            throw new WXException("WX Json response is null");
        }
        if (!wxJsonResponse.isSuccess()) {
            throw new WXException(wxJsonResponse.getCode(), wxJsonResponse.getMsg());
        }
    }
}
