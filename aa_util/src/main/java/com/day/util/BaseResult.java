package com.day.util;

/**
 * @program: solar
 * @description: 基础返回结果
 * @author: noahw
 * @create: 2020-03-25 09:02
 */
public class BaseResult<T> {

    private String desc;

    private String resultCode;

    private T data;

    public BaseResult() {
        this.desc = "业务处理成功";
        this.resultCode = "10000";
    }

    public BaseResult(String resultCode,String desc, T data) {
        this.desc = desc;
        this.resultCode = resultCode;
        this.data = data;
    }

    public BaseResult(String resultCode,String desc){
        this.desc=desc;
        this.resultCode=resultCode;
    }

    public BaseResult(T data) {
        this.data = data;
        this.desc = "业务处理成功";
        this.resultCode = "10000";
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}