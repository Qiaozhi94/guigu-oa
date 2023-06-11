package com.qiaozhi.auth.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiaozhi.auth.service.SysRoleService;
import com.qiaozhi.common.result.Result;
import com.qiaozhi.model.system.SysRole;

import com.qiaozhi.vo.system.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Georg
 */


@Api("角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    //注入service
    @Autowired
    private SysRoleService sysRoleService;


    //查询所有角色
    @ApiOperation("查询所有的角色")
    @GetMapping("/findALL")
    public Result findAll(){
        List<SysRole> list = sysRoleService.list();
        return Result.success(list);
    }


    //条件分页查询
    //page 当前页
    //limit 每页显示的数目
    //SysRoleQueryVo 条件查询对象
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page, @PathVariable Long limit, SysRoleQueryVo sysRoleQueryVo){

        //调用service的方法实现
        //创建page对象，传递分页参数
        Page<SysRole> pageParam = new Page<>(page, limit);

        //封装条件，判断条件是否为空，不为空进行封装
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper();
        String roleName = sysRoleQueryVo.getRoleName();
        if (!StringUtils.isEmpty(roleName)) {
            wrapper.like(SysRole::getRoleName, roleName);
        }

        //调用方法实现
        IPage<SysRole> pageModel = sysRoleService.page(pageParam, wrapper);
        return Result.success(pageModel);
    }

    //添加角色
    @ApiOperation("添加角色")
    @PostMapping("/addRole")
    public Result addRole(@RequestBody SysRole sysRole){
        boolean addResult = sysRoleService.save(sysRole);
        if (addResult){
            return Result.success(sysRole);
        }else {
            return Result.fail(null);
        }
    }

    //根据id查询角色
    @ApiOperation("根据id查询角色")
    @GetMapping("/getRoleById/{id}")
    public Result getRoleById(@PathVariable Long id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.success(sysRole);
    }

    //根据id修改角色
    @ApiOperation("根据id修改角色")
    @PostMapping("/update")
    public Result updateRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if (isSuccess){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

    //根据id删除角色
    @ApiOperation("根据id删除角色")
    @DeleteMapping("/deleteRoleById")
    public Result deleteRole(@RequestBody SysRole sysRole){
        boolean deleteResult = sysRoleService.removeById(sysRole);
        if (deleteResult){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

    //根据id批量删除角色
    @ApiOperation("根据id批量删除角色")
    @DeleteMapping("/deleteRolesByIds")
    public Result deleteRolesByIds(@RequestBody List<Long> idList){
        boolean deleteResult = sysRoleService.removeByIds(idList);
        if (deleteResult){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

}


