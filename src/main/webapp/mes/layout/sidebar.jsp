<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar">
    <div class="brand">
        <a href="/main.do" class="logo" target="container_target">CHBIO_MES</a>
        <a href="/logout.do" class="btn-xs">로그아웃</a>
    </div>

    <ul class="sidebar-nav">
        <li class="sidebar-item">
            <label>기준정보관리</label>
            <nav>
                <a href="/account/list.do" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">거래처관리</a>
                <a href="" class="sidebar-link ${param.active == 'material' ? 'active' : ''}" target="container_target">자재관리</a>
                <a href="" class="sidebar-link ${param.active == 'productList' ? 'active' : ''}" target="container_target">제품관리</a>
                <a href="" class="sidebar-link ${param.active == 'userList' ? 'active' : ''} " target="container_target">사용자관리</a>
                <a href="" class="sidebar-link ${param.active == 'userList' ? 'active' : ''} " target="container_target">회사정보관리</a>
                <a href="" class="sidebar-link ${param.active == 'userLogList' ? 'active' : ''}" target="container_target">로그기록</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>자재관리</label>
            <nav>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">자재자가처리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">발주관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">입고관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">출고관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">자재 입/출고현황</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">자재재고조회</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>제품관리</label>
            <nav>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">제품자가처리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">제품생산관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">제품수주관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">제품재고조회</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>생산관리</label>
            <nav>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">작업지시서</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">작업지시현황</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>출고관리</label>
            <nav>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">제품출고관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">기간별 출고현황</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">제품별 출고현황</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">거래명세표관리</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>품질관리</label>
            <nav>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">반품관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">클레임관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">입고검사관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">공정검사관리</a>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">출고검사관리</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>모니터링</label>
            <nav>
                <a href="" class="sidebar-link ${param.active == 'accountList' ? 'active' : ''}" target="container_target">자동화장비 I/F</a>
            </nav>
        </li>
    </ul>
</div>