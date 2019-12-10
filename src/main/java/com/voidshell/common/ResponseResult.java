package com.voidshell.common;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ResponseResult {

    private int status;
    private String code;
    private String msg;
    private Map<String,Object> content;

    public static ResponseResult createComm(int status ,String code,String msg){
        ResponseResult rr = new ResponseResult();
        rr.setStatus(status);
        rr.setCode(code);
        rr.setMsg(msg);
        return rr;
    }

    public static ResponseResult createData(int status ,String code,String msg,Map map){
        ResponseResult rr = createComm(status,code,msg);
        rr.setContent(map);
        return rr;
    }

    public static ResponseResult createList(int status ,String code,String msg,int size,List list){
        ResponseResult rr = createComm(status,code,msg);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("size",size);
        map.put("list",list);
        rr.setContent(map);
        return rr;
    }
}
