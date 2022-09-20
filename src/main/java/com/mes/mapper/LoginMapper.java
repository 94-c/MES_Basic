package com.mes.mapper;

import com.mes.data.dto.UserDto;
import com.mes.util.HashGenerator;

import javax.servlet.http.HttpServletRequest;

public class LoginMapper {

    public static UserDto mapToByLogin(HttpServletRequest request) {
        return UserDto.builder()
                .userId(request.getParameter("userId"))
                .password(request.getParameter("password"))
                .build();
    }
}
