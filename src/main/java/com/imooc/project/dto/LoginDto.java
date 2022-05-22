package com.imooc.project.dto;

import com.imooc.project.entity.Account;
import lombok.Data;

@Data
public class LoginDto {

    private String path;

    private String error;

    /*
    登录人信息
     */
    private Account account;
}
