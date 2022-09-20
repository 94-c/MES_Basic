package com.mes.service;

import com.mes.data.dao.account.AccountDao;
import com.mes.data.dto.AccountDto;
import com.mes.data.entity.Account;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountService {

    private final AccountDao accountDao = new AccountDao();

    public Account createAccount(AccountDto dto) {
        Account newAccountDto = dto.toCreateEntity();
        Account newAccount = accountDao.create(newAccountDto);
        if (newAccount == null) {
            return null;
        }
        return newAccount;
    }
}
