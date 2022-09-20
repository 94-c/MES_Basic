package com.mes.service;


import com.mes.data.dao.LoginQueryDao;
import com.mes.data.dao.user.UserDao;
import com.mes.data.dto.UserDto;
import com.mes.data.entity.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginService {

    private final UserDao userDao = new UserDao();
    private final LoginQueryDao loginQueryDao = new LoginQueryDao();

    public User login(UserDto dto) {
        User login = loginQueryDao.checkLogin(dto);
        if (login == null) {
            return null;
        }
        return userDao.find(login.getId());
    }
}
