package com.imooc.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.project.dao.ResourceMapper;
import com.imooc.project.entity.Resource;
import com.imooc.project.service.ResourceService;
import com.imooc.project.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author Yale
 * @since 2022-05-21
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    ResourceService resourceService;
    @Autowired
    ResourceMapper resourceMapper;

    /**
     * 根据角色ID查询该角色所具有的资源
     *
     * @param roleId
     * @return
     */
    @Override
    public List<ResourceVO> listResourceByRoleId(Long roleId) {

        QueryWrapper<Resource> query = new QueryWrapper();
        query.eq("rr.role_id", roleId).isNull("re.parent_id");

        System.out.println("************");

        List<ResourceVO> resourceVOS = resourceMapper.listResource(query);

        resourceVOS.forEach(r -> {
            Long resourceId = r.getResourceId();
            QueryWrapper<Resource> subWrapper = Wrappers.<Resource>query();
            subWrapper.eq("rr.role_id", roleId)
                    .eq("re.parent_id", resourceId);
            List<ResourceVO> subResourceVOS = baseMapper.listResource(query);
            if (CollectionUtils.isNotEmpty(subResourceVOS)) {
                r.setSubs(subResourceVOS);
            }
        });

        //分界线

//        List<ResourceVO> resourceVOS = baseMapper.listResource(query);
//
//        resourceVOS.forEach(r -> {
//            Long resourceId = r.getResourceId();
//            QueryWrapper<Resource> subWrapper = Wrappers.<Resource>query();
//            subWrapper.eq("rr.role_id", roleId)
//                    .eq("re.parent_id", resourceId);
//            List<ResourceVO> subResourceVOS = baseMapper.listResource(subWrapper);
//            if (CollectionUtils.isNotEmpty(subResourceVOS)) {
//                r.setSubs(subResourceVOS);
//            }
//        });

        //分界线
//        List<ResourceVO> resourceVOS3 = new ArrayList<>();
        return resourceVOS;
    }
}
