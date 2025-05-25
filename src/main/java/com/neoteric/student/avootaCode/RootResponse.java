package com.neoteric.student.avootaCode;

public class RootResponse {

    public ResponseData getResponse() {
        return response;
    }

    public void setResponse(ResponseData response) {
        this.response = response;
    }

    public String getAvootaStatus() {
        return avootaStatus;
    }

    public void setAvootaStatus(String avootaStatus) {
        this.avootaStatus = avootaStatus;
    }

    private String avootaStatus;
    private ResponseData response;


}
