package com.mes.controller;

import com.mes.data.dto.AccountDto;
import com.mes.data.entity.Account;
import com.mes.mapper.AccountMapper;
import com.mes.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccountController implements Controller{

    private final AccountService accountService;

    public CreateAccountController() {
        this.accountService = new AccountService();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/mes/account/accountInputForm.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {

        AccountDto dto = AccountMapper.mapToCreate(request);
        Account newAccount = accountService.createAccount(dto);
        
        if (newAccount == null) {
            request.setAttribute("message", "거래처 등록이 실패하였습니다.");
            request.setAttribute("target", "/account/list.do");
            return "/mes/script/redirect.jsp";
        }
        request.setAttribute("message", "거래처 등록이 성공하였습니다.");
        request.setAttribute("target", "/account/list.do");
        return "/mes/script/redirect.jsp";
    }
}
