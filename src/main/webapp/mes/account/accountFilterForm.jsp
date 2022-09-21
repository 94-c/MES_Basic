<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="GET" action="/account/list.do">
    <table class="table-input">
        <colgroup>
            <col width="10%">
            <col width="22%">
            <col width="10%">
            <col width="22%">
            <col width="10%">
            <col width="*">
        </colgroup>
        <tbody>
        <tr>
            <th>유형</th>
            <td>
                <select id="account_kind" name="account_kind" class="form-control xs">
                    <c:forEach items="${systemCodeDetailList}" var="type">
                        <option value='<c:out value="${type.codeDetailName}"/>'
                                <c:if test="${account.type == type.codeDetailName}">selected="selected"</c:if>>
                            <c:out value="${type.codeDetailName}"/>
                        </option>
                    </c:forEach>
                </select>
            </td>
            <th>거래처코드</th>
            <td><input type="text" name="account_code" class="form-control xs" value="${searchKeyWord.accountCode}">
            </td>
            <th>거래처명</th>
            <td><input type="text" name="account_name" class="form-control xs" value="${searchKeyWord.accountName}">
            </td>
        </tr>
        </tbody>
    </table>

    <div class="mt-1 mb-1 txt-right">
        <button type="submit" class="btn">
            <i class="fa fa-search" aria-hidden="true"></i>
            검색하기
        </button>
    </div>

    <div class="flex-content-between mb-1">
        <div class="ft-bold">
            Total : ${totalAccountCount} 건
        </div>
        <div>
            <button type="button" id="btnCreateAccount" class="btn btn-primary">
                <i class="fa fa-pencil" aria-hidden="true"></i>
                등록하기
            </button>
            <button type="button" id="btnDeleteAccount" name="btnDeleteAccount" class="btn btn-danger">
                <i class="fa fa-trash-o" aria-hidden="true"></i>
                삭제하기
            </button>
            <button type="button" class="btn btn-success" onclick="location.href='/accountListExcel'">
                <i class="fa fa-file-excel-o" aria-hidden="true"></i>
                Excel 다운로드
            </button>
        </div>
    </div>
</form>
