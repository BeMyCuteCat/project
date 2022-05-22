package com.imooc.project;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.project.entity.Role;
import com.imooc.project.dao.ResourceMapper;
import com.imooc.project.entity.Resource;
import com.imooc.project.dao.RoleMapper;
import com.imooc.project.service.RoleService;
import com.imooc.project.vo.ResourceVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	ResourceMapper resourceMapper;
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	RoleService roleService;

	@Test
	void contextLoads() {
		QueryWrapper<Resource> query = new QueryWrapper();
		query.eq("rr.role_id", 1L).isNull("re.parent_id");

		System.out.println("************");
		List<ResourceVO> resources = resourceMapper.listResource(query);
		resources.forEach(r -> {
			System.out.println(r);
		});
	}

	@Test
	void contextLoads1() {

		System.out.println("************");
		List<Resource> resources = resourceMapper.findByResourceId(1L);
		resources.forEach(r -> {
			System.out.println(r);
		});
	}

	@Test
	void contextLoads2() {

		System.out.println("************");
		List<Role> roles = roleService.listRoles();
		roles.forEach(r -> {
			System.out.println(r);
		});
	}
}