package com.hundsun.extoperatemonitordome.util;

/**
 * 功能说明:
 *
 * @author daweizai36273
 * @date 2022/10/10 20:12
 */
public class ResponseData<T> {
    private String returnCode = "0";
    private String returnMsg = "";
    private T returnData;

    public ResponseData() {
    }

    public ResponseData(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public ResponseData(String returnCode, String returnMsg, T returnData) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.returnData = returnData;
    }

    public ResponseData(T returnData) {
        this.returnData = returnData;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public T getReturnData() {
        return returnData;
    }

    public void setReturnData(T returnData) {
        this.returnData = returnData;
    }


    public ResponseData<T> success(T returnData) {
        this.returnData = returnData;
        return this;
    }

    public ResponseData<T> error(String errorCode, String errorMessage) {
        this.returnCode = errorCode;
        this.returnMsg = errorMessage;
        return this;
    }

    public ResponseData<T> error(String errorMessage) {
        this.returnCode = "-1";
        this.returnMsg = errorMessage;
        return this;
    }
}
