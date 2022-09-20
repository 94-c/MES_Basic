package com.mes.data.dao;

import com.mes.data.dto.UserDto;
import com.mes.data.entity.User;
import com.mes.util.DBUtil;
import com.mes.util.HashGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginQueryDao extends QueryDao {

    private User newUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("u.id"));
        user.setUserId(rs.getString("u.user_id"));
        user.setName(rs.getString("u.name"));

        return user;
    }

    public String makeLoginCheckQuery(UserDto dto) {
        String sql = "SELECT u.id, u.name, u.user_id ";
        sql += " FROM users u ";
        sql += " where u.user_id = '" + dto.getUserId() + "'";
        sql += " AND u.password = '" + HashGenerator.generateMD5(dto.getPassword()) + "'";
        return sql;
    }

    public User checkLogin(UserDto dto) {

        String sql = makeLoginCheckQuery(dto);

        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
               return newUser(rs);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
