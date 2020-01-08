package com.voidshell.service.userManage;

import com.voidshell.dao.userManage.VsUmUpMapper;
import com.voidshell.dao.userManage.VsUmUrMapper;
import com.voidshell.pojo.userManage.VsUmPermission;
import com.voidshell.pojo.userManage.VsUmRole;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private VsUmUrMapper vsUmUrMapper;
    @Autowired
    private VsUmUpMapper vsUmUpMapper;
    @Autowired
    private VsUmRole vsUmRole;
    @Autowired
    private VsUmPermission vsUmPermission;

    public int SetUserRole(String userId,String Role){

        return 0;
    }

}
