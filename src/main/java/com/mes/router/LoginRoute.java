package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.LoginController;

import java.util.Map;

public class LoginRoute {
    public LoginRoute(Map<String, Controller> routes) {
        routes.put("/login.do", new LoginController());
    }
}
