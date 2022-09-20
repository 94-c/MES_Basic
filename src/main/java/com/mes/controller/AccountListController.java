package com.mes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountListController implements Controller{

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/mes/account/accountList.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
