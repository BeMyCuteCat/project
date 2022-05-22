package com.imooc.project.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.project.entity.Resource;
import com.imooc.project.vo.ResourceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author Yale
 * @since 2022-05-21
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * 查询当前登录人的资源，参考https://baomidou.com/pages/10c804/#%E7%94%A8%E6%B3%A8%E8%A7%A3
//     * @param wrapper
     */
//    @Select("SELECT\n" +
//            "        re.resource_id,\n" +
//            "        re.resource_name,\n" +
//            "        re.url\n" +
//            "        FROM resource AS re INNER JOIN role_resource AS rr\n" +
//            "        ON re.resource_id = rr.resource_id")
    List<ResourceVO> listResource(@Param("ew") QueryWrapper<Resource> wrapper);

    List<Resource> findByResourceId(Long resourceId);


}
