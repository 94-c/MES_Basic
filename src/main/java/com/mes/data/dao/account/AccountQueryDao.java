package com.mes.data.dao.account;

import com.mes.data.dao.QueryDao;
import com.mes.data.dto.AccountDto;
import com.mes.data.entity.Account;
import com.mes.data.model.Address;
import com.mes.data.model.Business;
import com.mes.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountQueryDao extends QueryDao {

    private Account newAccount(ResultSet result) throws SQLException {
        Business business = new Business(result.getString("business_number"), result.getString("business_type"), result.getString("business_category"));
        Address addressOne = new Address(result.getString("zip_code1"), result.getString("address1"), result.getString("address_detail1"));
        Address addressTwo = new Address(result.getString("zip_code2"), result.getString("address2"), result.getString("address_detail2"));

        Account accounts = new Account();
        accounts.setId(result.getInt("id"));
        accounts.setCode(result.getString("code"));
        accounts.setName(result.getString("name"));
        accounts.setBusiness(business);
        accounts.setCeo(result.getString("ceo"));
        accounts.setTel(result.getString("tel"));
        accounts.setEmail(result.getString("email"));
        accounts.setFax(result.getString("fax"));
        accounts.setAddress1(addressOne);
        accounts.setAddress2(addressTwo);
        accounts.setType(result.getString("type"));
        accounts.setEtc(result.getString("etc"));
        accounts.setCreatedAt(result.getDate("created_at"));
        accounts.setUpdatedAt(result.getDate("updated_at"));
        accounts.setDeleteState(result.getInt("delete_state"));

        return accounts;
    }

    private String makeAccountQuery(String type, AccountDto dto) {
        String sql = " SELECT ";
        sql += type.equals("list")
                ? " * "
                : " COUNT(*) AS count ";
        sql += " FROM accounts ";
        sql += " WHERE delete_state = 0 ";
        sql += whereLike(" type ", dto.getType());
        sql += whereLike( " code ", dto.getCode());
        sql += whereLike( " name ", dto.getName());
        if (type.equals("list")) {
            sql += orderBy(" created_at ", " DESC ");
        }
        return sql;
    }

    public long countOfAccount(AccountDto dto) {
        long count = 0;

        String sql = makeAccountQuery("count", dto);

        try(Connection conn = DBUtil.getDataSource().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                count = rs.getLong("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Account> findAllAccount(AccountDto dto) {
        List<Account> accountList = new ArrayList<>();

        String sql = makeAccountQuery("list", dto);

        try(Connection conn = DBUtil.getDataSource().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Account account = newAccount(rs);
                accountList.add(account);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return accountList;
    }
}
