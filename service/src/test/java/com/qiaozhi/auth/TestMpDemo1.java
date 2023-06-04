package com.qiaozhi.auth;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.xdevapi.Warning;
import com.qiaozhi.auth.mapper.SysRoleMapper;
import com.qiaozhi.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.mockito.internal.debugging.WarningsPrinterImpl;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMpDemo1 {

    @Resource
    private SysRoleMapper mapper;

    //查询所有记录
    @Test
    public void getAll(){
        List<SysRole> list = mapper.selectList(null);
        System.out.println(list);
    }
    //添加数据
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");

        int rows = mapper.insert(sysRole);
        System.out.println(sysRole);
        System.out.println(rows);
    }


    //修改数据
    @Test
    public void update(){
        SysRole role = mapper.selectById(10);
        role.setRoleName("角色管理员test");
        int rows1 = mapper.updateById(role);
        System.out.println(rows1);

    }

    //逻辑删除数据
    @Test
    public void deleteById(){
        int rows2 = mapper.deleteById(10);
    }

    //批量逻辑删除数据
    @Test
    public void deleteBatchIds(){
        int result = mapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }

    //条件查询数据
    @Test
    public void testQuery1(){
        //创建QueryWrapper对象，调用方法来封装条件
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name", "系统管理员");

        //调用mp方法实现查询操作
        List<SysRole> list = mapper.selectList(wrapper);
        System.out.println(list);
    }

    //使用lambda实现条件查询数据
    @Test
    public void testQuery2(){
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName, "系统管理员");
        List<SysRole> list = mapper.selectList(wrapper);
        System.out.println(list);
    }
}
