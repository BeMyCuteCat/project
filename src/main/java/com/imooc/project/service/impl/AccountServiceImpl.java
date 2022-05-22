package com.imooc.project.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.project.dao.AccountMapper;
import com.imooc.project.dto.LoginDto;
import com.imooc.project.entity.Account;
import com.imooc.project.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号表 服务实现类
 * </p>
 *
 * @author Yale
 * @since 2022-05-21
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    public LoginDto login(String username, String password) {
        LoginDto loginDto = new LoginDto();
        loginDto.setPath("redirect:/");


        Account account = lambdaQuery().eq(Account::getUsername, username).one();

        if (null == account) {
            loginDto.setError("用户名不存在");
            return loginDto;
        }

        MD5 md5 = new MD5(account.getSalt().getBytes());
        String digestHex = md5.digestHex(password);

        if (!digestHex.equals(account.getPassword())) {
            loginDto.setError("密码错误");
            return loginDto;
        }

        loginDto.setAccount(account);
        loginDto.setPath("login/main");
        return loginDto;
    }
}
