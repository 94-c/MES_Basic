package com.mes.controller;

import com.mes.data.dto.AccountDto;
import com.mes.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AccountListController implements Controller{

    private final AccountService accountService;

    public AccountListController() {
        this.accountService = new AccountService();
    }

    private void setNavigation(HttpServletRequest request) {
        List<String> navigation = new ArrayList<>();
        navigation.add("거래처 관리");
        navigation.add("거래처 정보 관리");

        request.setAttribute("navigation", navigation);
    }

    private AccountDto makeDto(HttpServletRequest request) {
        return AccountDto.builder()
                .type(request.getParameter("type"))
                .name(request.getParameter("name"))
                .code(request.getParameter("code"))
                .build();
    }

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        setNavigation(request);

        AccountDto result = accountService.findAllAccount(makeDto(request));

        request.setAttribute("accountList", result.getAccountList());
        request.setAttribute("totalAccountCount", result.getTotalCount());

        return "/mes/account/accountList.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
