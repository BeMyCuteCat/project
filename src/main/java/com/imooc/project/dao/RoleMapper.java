package com.imooc.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.project.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScans;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author Yale
 * @since 2022-05-21
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

//    @Select("select * from role")
    List<Role> listRoles();
}
