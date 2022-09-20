package com.mes.data.dao.account;

import com.mes.data.dao.JpaDao;
import com.mes.data.entity.Account;

import java.util.Date;

public class AccountDao extends JpaDao<Account> {

    @Override
    public Account create(Account account) {
        account.setCreatedAt(new Date());
        return super.create(account);
    }

    @Override
    public Account update(Account account) {
        account.setUpdatedAt(new Date());
        return super.update(account);
    }

    public Account find(Object id) {
        return super.find(Account.class, id);
    }
}
