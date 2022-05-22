package com.imooc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.project.entity.Role;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Yale
 * @since 2022-05-21
 */
public interface RoleService extends IService<Role> {

    List<Role> listRoles();
}
