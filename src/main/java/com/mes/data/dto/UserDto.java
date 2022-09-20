package com.mes.data.dto;

import com.mes.data.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private Integer id;
    private String userId;
    private String password;
    private String name;
    private String department;
    private String position;
    private String tel;
    private String phone;
    private String email;
    private String address;
    private String addressDetail;
    private String zipCode;
    private String etc;

    public User toLoginEntity() {
        User login = new User();
        login.setUserId(userId);
        login.setPassword(password);
        return login;
    }
}
