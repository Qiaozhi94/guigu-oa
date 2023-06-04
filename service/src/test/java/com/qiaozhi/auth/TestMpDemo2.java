package com.qiaozhi.auth;


import com.qiaozhi.auth.service.SysRoleService;
import com.qiaozhi.model.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMpDemo2 {


    @Autowired
    private SysRoleService service;

    //查询所有记录
    public void getAll(){
        List<SysRole> list = service.list();
        System.out.println(list);
    }

}
