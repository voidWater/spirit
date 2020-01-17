package com.voidshell.common;

import lombok.Data;

import java.util.Map;

@Data
public class AntResult {
    private Integer code;
    private String message;
    private Map<String,Object> data;
}
