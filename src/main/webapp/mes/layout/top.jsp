<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MES :: ${ URLDecoder.decode(param.title) }</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/colorbox.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fullcalendar.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/chart.css" />

    <link rel="icon" href="../../images/favicon.ico" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.colorbox-min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mtz.monthPicker.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/fullcalendar.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-barcode.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsBarcode.all.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
</head>
<body>