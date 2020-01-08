package com.voidshell.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserBO {

    private Date loginDate;
    private String ip;
}
