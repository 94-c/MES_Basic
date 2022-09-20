package com.mes.router;

import com.mes.controller.AccountListController;
import com.mes.controller.Controller;
import com.mes.controller.CreateAccountController;
import com.mes.data.entity.Account;

import java.util.Map;

public class AccountRouter {
    public AccountRouter(Map<String, Controller> routers) {
        routers.put("/account/list.do", new AccountListController());
        routers.put("/account/create.do", new CreateAccountController());
    }
}
