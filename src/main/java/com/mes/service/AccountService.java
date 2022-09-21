package com.mes.service;

import com.mes.data.dao.account.AccountDao;
import com.mes.data.dao.account.AccountQueryDao;
import com.mes.data.dto.AccountDto;
import com.mes.data.entity.Account;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccountService {

    private final AccountDao accountDao = new AccountDao();
    private final AccountQueryDao accountQueryDao = new AccountQueryDao();

    public AccountDto findAllAccount(AccountDto dto) {
        List<Account> accountList = accountQueryDao.findAllAccount(dto);
        long accountTotalCount = accountQueryDao.countOfAccount(dto);
        return AccountDto.builder()
                .accountList(accountList)
                .totalCount(accountTotalCount)
                .build();
    }

    public Account createAccount(AccountDto dto) {
        Account newAccountDto = dto.toCreateEntity();
        Account newAccount = accountDao.create(newAccountDto);
        if (newAccount == null) {
            return null;
        }
        return newAccount;
    }
}
