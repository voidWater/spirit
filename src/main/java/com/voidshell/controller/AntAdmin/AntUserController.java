package com.voidshell.controller.AntAdmin;

import com.voidshell.pojo.ant.AntPermissions;
import com.voidshell.pojo.ant.AntResult;
import com.voidshell.pojo.ant.AntRole;
import com.voidshell.pojo.ant.AntUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("user")
public class AntUserController {
    @RequestMapping("/info")
    public AntResult AntLogin(String username, String  password, HttpSession session){
        System.out.println(session.getAttribute("userToken"));
        AntResult ar = new AntResult();
        ar.setCode(200);
        ar.setMessage("ok");
        AntUser user = new AntUser();
        user.setId("4291d7da9005377ec9aec4a71ea837f");
        user.setName("天野远子1231");
        user.setUsername("admin");
        user.setPassword("");
        user.setAvatar("/avatar2.jpg");
        user.setStatus(1);
        user.setTelephone("");
        user.setCreatorId("admin");
        user.setCreateTime(1497160610259L);
        user.setDeleted(0);
        user.setRoleId("admin");
        AntRole role = new AntRole();
//        'id': 'admin',
//                'name': '管理员',
//                'describe': '拥有所有权限',
//                'status': 1,
//                'creatorId': 'system',
//                'createTime': 1497160610259,
//                'deleted': 0,
        role.setId("admin");
        role.setName("管理员");
        role.setDescribe("拥有所有权限");
        role.setStatus(1);
        role.setCreatorId("system");
        role.setCreateTime(new Date());
        role.setDeleted(0);
//                'actions': '[{"action":"add","defaultCheck":false,"describe":"新增"},{"action":"query","defaultCheck":false,"describe":"查询"},{"action":"get","defaultCheck":false,"describe":"详情"},{"action":"update","defaultCheck":false,"describe":"修改"},{"action":"delete","defaultCheck":false,"describe":"删除"}]',
//                'actionEntitySet': [{
//            'action': 'add',
//                    'describe': '新增',
//                    'defaultCheck': false
//        }, {
//            'action': 'query',
//                    'describe': '查询',
//                    'defaultCheck': false
//        }, {
//            'action': 'get',
//                    'describe': '详情',
//                    'defaultCheck': false
//        }, {
//            'action': 'update',
//                    'describe': '修改',
//                    'defaultCheck': false
//        }, {
//            'action': 'delete',
//                    'describe': '删除',
//                    'defaultCheck': false
//        }],
        List<AntPermissions> list = new ArrayList<AntPermissions>();
        AntPermissions per = new AntPermissions();
        per.setRoleId("admin");
        per.setPermissionId("dashboard");
        per.setPermissionName("仪表盘");
        list.add(per);
        role.setPermissions(list);
        user.setRole(role);
        ar.setResult(user);
        Map<String ,Object> rm2 = new HashMap<>();
        rm2.put("Custom-Header",UUID.randomUUID().toString());
        ar.set_headers(rm2);
        ar.setTimestap(System.currentTimeMillis());
        return ar;
    }
}
