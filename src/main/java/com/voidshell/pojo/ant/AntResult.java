package com.voidshell.pojo.ant;

import lombok.Data;

import java.util.Map;

@Data
public class AntResult {
    private Integer code;
    private String message;
    private Long timestap;
    private Object result;
    private Map<String,Object> _headers;
}
