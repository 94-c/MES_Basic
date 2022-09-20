<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="layout/top.jsp">
    <jsp:param name="title" value="${URLEncoder.encode(\"메인\")}"/>
</jsp:include>

<div class="wrapper">
    <jsp:include page="layout/sidebar.jsp"/>

    <iframe class="container" name="container_target"/>
    <div id="content">
        <div class="content-header">
            <c:if test="${navigation ne null}">
                <c:forEach var="title" items="${navigation}" varStatus="status" begin="${fn:length(navigation)-1}">
                    <p class="title">${title}</p>
                </c:forEach>

                <ol class="breadcrumb">
                    <li><i class="fa fa-home" aria-hidden="true"></i></li>
                    <c:forEach var="menu" items="${navigation}" varStatus="status">
                        <li>${ menu }</li>
                    </c:forEach>
                </ol>
            </c:if>
        </div>

        <div class="box box-bg" style="height: 920px">
            <div class="content-header">
                <p class="title" style="color: #ffffff">메인</p>

                <ol class="breadcrumb">
                    <li><i class="fa fa-home" aria-hidden="true"></i></li>
                    <li>메인</li>
                </ol>
                <div style="text-align: center; margin-top: 300px ">
                    <img src="../images/logo.jpg" style="margin-top: -100px">
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="layout/bottom.jsp"/>