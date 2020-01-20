package com.voidshell.pojo.ant;

import lombok.Data;

/**
 * Auto-generated: 2020-01-15 15:22:22
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class AntUser {
    private String id;
    private String name;
    private String username;
    private String password;
    private String avatar;
    private int status;
    private String telephone;
    private String lastLoginIp;
    private long lastLoginTime;
    private String creatorId;
    private long createTime;
    private int deleted;
    private String roleId;
    private AntRole role;
}