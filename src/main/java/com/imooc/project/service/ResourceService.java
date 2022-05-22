package com.imooc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.project.entity.Resource;
import com.imooc.project.vo.ResourceVO;

import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author Yale
 * @since 2022-05-21
 */
public interface ResourceService extends IService<Resource> {

    /**
     * 根据角色ID查询该角色所具有的资源
     * @param roleId
     * @return
     */
    List<ResourceVO> listResourceByRoleId(Long roleId);

}
