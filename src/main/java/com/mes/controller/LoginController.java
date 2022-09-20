package com.mes.controller;

import com.mes.data.dto.UserDto;
import com.mes.data.entity.User;
import com.mes.mapper.LoginMapper;
import com.mes.service.LoginService;
import com.mes.service.UserService;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {

    private final LoginService loginService;

    public LoginController() {
        this.loginService = new LoginService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("SESSION_ID") != null) {
            request.setAttribute("target", "/main.do");
            return "/mes/script/redirect.jsp";
        }
        request.setAttribute("message", "아이디 및 비밀번호를 확인해주세요");
        return "/mes/login.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserDto loginDTO = LoginMapper.mapToByLogin(request);
        User user = loginService.login(loginDTO);

        if (user == null) {
            request.setAttribute("message", "아이디 및 비밀번호를 확인해주세요");
            request.setAttribute("target", "/login.do");
            return "/mes/script/redirect.jsp";
        }
        session.setAttribute("SESSION_USERID", user.getUserId());
        session.setAttribute("SESSION_NAME", user.getName());
        session.setAttribute("SESSION_ID", user.getId());
        session.setAttribute("target", "/main.do");
        return "/mes/script/redirect.jsp";
    }
}
