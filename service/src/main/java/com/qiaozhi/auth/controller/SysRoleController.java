package com.qiaozhi.auth.controller;


import com.qiaozhi.auth.service.SysRoleService;
import com.qiaozhi.common.result.Result;
import com.qiaozhi.model.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Georg
 */
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    //注入service
    @Autowired
    private SysRoleService sysRoleService;


    //统一返回数据结果
    @GetMapping("/findALL")
    public Result findAll(){
        List<SysRole> list = sysRoleService.list();
        return Result.success(list);
    }
}
