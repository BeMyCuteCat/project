package com.imooc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.project.dto.LoginDto;
import com.imooc.project.entity.Account;

/**
 * <p>
 * 账号表 服务类
 * </p>
 *
 * @author Yale
 * @since 2022-05-21
 */
public interface AccountService extends IService<Account> {

    LoginDto login(String username, String password);
}
