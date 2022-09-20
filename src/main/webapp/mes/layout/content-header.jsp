<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper">
    <jsp:include page="../layout/sidebar.jsp">
        <jsp:param name="active" value="${activeValue}"/>
    </jsp:include>

