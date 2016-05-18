package com.cppba.core.weixin.token.response;

import com.cppba.core.weixin.base.response.WXJsonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/7.
 */
@Getter
public class WXTokenResponse extends WXJsonResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private long expires;

    public WXTokenResponse() {
        super();
    }
}
