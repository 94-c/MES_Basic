package com.mes.router;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("*.do")
public class WebRouter extends HttpServlet {
    private final Map<String, Controller> routes = new HashMap<>();

    @Override
    public void init() throws ServletException {
        new LoginRoute(routes);
        new MainRouter(routes);
        new AccountRouter(routes);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = url.substring(contextPath.length());

        if (routes.containsKey(path)) {
            Controller controller = routes.get(path);

            String method = req.getMethod();
            if (method.equals("GET")) {
                render(req, resp, controller.doGet(req, resp));
            } else if (method.equals("POST")) {
                render(req, resp, controller.doPost(req, resp));
            } else {
                System.out.println("Not Access");
            }
        } else {
            System.out.println("Not Found");
        }
    }


    private void render(HttpServletRequest req, HttpServletResponse resp, String viewFilePath) throws ServletException, IOException {
        if (viewFilePath == null) {
            System.out.println("Empty File Path");
            return;
        }

        req.getRequestDispatcher(viewFilePath).forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
