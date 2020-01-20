package com.voidshell.pojo.ant;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AntRole {
//    'id': 'admin',
//    'name': '管理员',
//    'describe': '拥有所有权限',
//    'status': 1,
//    'creatorId': 'system',
//    'createTime': 1497160610259,
//    'deleted': 0,
    private String id;
    private String name;
    private String describe;
    private Integer status;
    private String creatorId;
    private Date createTime;
    private Integer deleted;
    private List<AntPermissions> permissions;
}
