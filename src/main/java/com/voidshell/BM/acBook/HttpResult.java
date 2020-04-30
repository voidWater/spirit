package com.voidshell.BM.acBook;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class HttpResult<T> implements Serializable {
    private Integer status;
    private String code;
    private String msg;
    private T data;

    public static <T>HttpResult success(String msg,T data){
        return new HttpResult(Const.ResponseCode.SUCCESS.getCode(),Const.ResponseCode.SUCCESS.getDesc(),msg,data);
    }
    public static <T>HttpResult success(String msg){
        return new HttpResult(Const.ResponseCode.SUCCESS.getCode(),Const.ResponseCode.SUCCESS.getDesc(),msg,null);
    }
    public static <T>HttpResult success(){
        return new HttpResult(Const.ResponseCode.SUCCESS.getCode(),Const.ResponseCode.SUCCESS.getDesc(),null,null);
    }

    public static<T>HttpResult error(String msg,T data){
        return new HttpResult(Const.ResponseCode.ERROR.getCode(),Const.ResponseCode.ERROR.getDesc(),msg,data);
    }
    public static<T>HttpResult error(String msg){
        return new HttpResult(Const.ResponseCode.ERROR.getCode(),Const.ResponseCode.ERROR.getDesc(),msg,null);
    }
    public static<T>HttpResult error(){
        return new HttpResult(Const.ResponseCode.ERROR.getCode(),Const.ResponseCode.ERROR.getDesc(),null,null);
    }
    public static<T>HttpResult error(Const.ResponseErrorCode errorCode){
        return new HttpResult(errorCode.getCode(),errorCode.getDesc(),null,null);
    }
    public static<T>HttpResult error(Const.ResponseErrorCode errorCode,String msg){
        return new HttpResult(errorCode.getCode(),errorCode.getDesc(),msg,null);
    }

    public HttpResult(Integer status, String code, String msg, T data) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
