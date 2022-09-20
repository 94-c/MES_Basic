package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.MainController;

import java.util.HashMap;
import java.util.Map;

public class MainRouter {
    public MainRouter (Map<String, Controller> routers) {
        routers.put("/main.do", new MainController());
    }
}
