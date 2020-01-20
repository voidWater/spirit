package com.voidshell.pojo.ant;

import lombok.Data;

@Data
public class AntPermissions {
//    roleId: "admin"
//    permissionId: "dashboard"
//    permissionName: "仪表盘"
//    actions: "[{"action":"add","defaultCheck":false,"describe":"新增"},{"action":"query","defaultCheck":false,"describe":"查询"},{"action":"get","defaultCheck":false,"describe":"详情"},{"action":"update","defaultCheck":false,"describe":"修改"},{"action":"delete","defaultCheck":false,"describe":"删除"}]"
//    actionEntitySet: (5) [{…}, {…}, {…}, {…}, {…}]
//    actionList: null
//    dataAccess: null
    private String roleId;
    private String permissionId;
    private String permissionName;
    private String actions;
    private String[] actionEntitySet;
    private String[] actionList;
    private String dataAccess;

}
