package com.mes.data.dao.user;

import com.mes.data.dao.JpaDao;
import com.mes.data.entity.User;

import java.util.Date;

public class UserDao extends JpaDao<User> {

    @Override
    public User create(User user) {
        user.setCreatedAt(new Date());
        return super.create(user);
    }

    @Override
    public User update(User user) {
        user.setUpdatedAt(new Date());
        return super.update(user);
    }

    public User find(Integer id) {
        return super.find(User.class, id);
    }
}
