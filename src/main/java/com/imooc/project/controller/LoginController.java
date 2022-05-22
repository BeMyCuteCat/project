package com.imooc.project.controller;

import com.imooc.project.dto.LoginDto;
import com.imooc.project.service.AccountService;
import com.imooc.project.service.ResourceService;
import com.imooc.project.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("auth")
public class LoginController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ResourceService resourceService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public String login(String username, String password, HttpSession session,
                        RedirectAttributes attributes, Model model) {

        LoginDto loginDto = accountService.login(username, password);
        String error = loginDto.getError();
        if (null == error) {
            session.setAttribute("account", loginDto.getAccount());
            List<ResourceVO> resourceVOS = resourceService.listResourceByRoleId(loginDto.getAccount().getRoleId());
            model.addAttribute("resource", resourceVOS);

        } else {
            attributes.addAttribute("error", error);
        }
        return loginDto.getPath();
    }

    /**
     * 登出方法
     * @param session
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
