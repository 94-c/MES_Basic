<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/top.jsp">
    <jsp:param name="title" value="${URLEncoder.encode(\"거래처 정보 관리\")}"/>
</jsp:include>
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

<div class="box box-bg">
    <jsp:include page="accountFilterForm.jsp"/>

    <table class="table-list full" style="text-align: center">
        <colgroup>
            <col width="50px">
            <col width="180px">
            <col width="200px">
            <col width="100px">
            <col width="150px">
            <col width="150px">
            <col width="100px">
        </colgroup>
        <thead>
        <tr>
            <th><input type="checkbox" name="checked_all"/></th>
            <th>거래처코드</th>
            <th>거래처명</th>
            <th>유형</th>
            <th>사업자번호</th>
            <th>대표자</th>
            <th>비고</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="accountList" items="${accountList}" varStatus="status">
            <tr>
                <td class="txt-center">
                    <input type="checkbox" id="id" name="idx[]" value="${accountList.id}"/>
                </td>
                <td><a href="/accountEdit.do?id=${accountList.id}">${accountList.code}</a></td>
                <td>${accountList.name}</td>
                <td>${accountList.type}</td>
                <td>${accountList.business.businessNumber}</td>
                <td>${accountList.ceo}</td>
                <td>${accountList.etc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('input:checkbox[name="checked_all"]').on('change', function (e) {
            $('input:checkbox[name="idx[]"]').prop('checked', $(this).prop('checked'));
        });

        $('input:checkbox[name="idx[]"]').on('change', function (e) {
            var totalCount = $('input:checkbox[name="idx[]"]').length;
            var totalCheckedCount = $('input:checkbox[name="idx[]"]:checked').length;

            $('input:checkbox[name="checked_all"]').prop('checked', (totalCount === totalCheckedCount));
        });

        $('#btnCreateAccount').on('click', function () {
            window.location.href = "/account/create.do";
        });

        $('#btnDeleteAccount').on('click', function () {
            let checkValueArr = [];
            let $checkbox = $('input:checkbox[name="idx[]"]:checked');

            for (let i = 0; i < $checkbox.length; i++) {
                checkValueArr.push($checkbox[i].value)
            }
            if ($checkbox.length == 0) {
                alert('선택된 항목이 없습니다.');
                return false;
            } else {
                if (confirm($checkbox.length + " 개의 거래처 정보를 삭제하시겠습니까?")) {
                    $.ajax({
                        url: "/accountDeleteProc.do",
                        type: 'POST',
                        traditional: true,
                        data: {
                            'selectedIds': checkValueArr,
                        }
                    }).done(function () {
                        window.location.reload();
                        alert($checkbox.length + " 개의 거래처 정보를 삭제되었습니다.")
                    })
                    console.log(id);
                    console.log($checkbox);
                    console.log(checkValueArr);
                } else {
                    window.location.reload();
                }
            }
            console.log('btnDeleteAccount')
        });
    });
</script>

<jsp:include page="../layout/bottom.jsp"/>