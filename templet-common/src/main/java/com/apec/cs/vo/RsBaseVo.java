package com.apec.cs.vo;

import com.apec.cs.constants.CsConstants;

public class RsBaseVo implements CsConstants{
    private String requestTime;
    private String responseTime;


    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }


}
