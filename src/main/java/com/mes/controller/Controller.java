package com.mes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    String doGet(HttpServletRequest request, HttpServletResponse response);
    String doPost(HttpServletRequest request, HttpServletResponse response);
}
