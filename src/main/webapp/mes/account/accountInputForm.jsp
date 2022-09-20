<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/top.jsp">
    <jsp:param name="title" value="${URLEncoder.encode(account == null ? \"거래처 등록하기\" : \"거래처 수정하기\")}"/>
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
    <c:set var="action" value="${account == null ? '/account/create.do' : '/account/edit.do'}"/>
    <form name="account-form" method="POST" action="${action}">
        <c:if test="${account != null}">
            <input type="hidden" name="id" value="${account.id}">
        </c:if>

        <table class="table-input xs">
            <colgroup>
                <col width="150px">
                <col width="*">
                <col width="150px">
                <col width="*">
            </colgroup>
            <tbody>
            <tr>
                <th>거래처코드</th>
                <td>
                    <c:if test="${account == null}">
                        <input type="text" id="account_code" name="account_code" class="form-control xs"
                               style="background-color: #e5e5e5" readonly>
                    </c:if>
                    <c:if test="${account != null}">
                        <input type="hidden" id="account_code" name="account_code" value="${account.code}">
                        ${account.code}
                    </c:if>

                </td>

                <th>유형 <strong>*</strong></th>
                <td>
                    <select id="type" name="type" class="form-control xs">
                        <c:forEach items="${systemCodeDetailList}" var="type">
                            <option value='<c:out value="${type.codeDetailName}"/>'
                                    <c:if test="${account.type == type.codeDetailName}">selected="selected"</c:if>>
                                <c:out value="${type.codeDetailName}"/>
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>거래처명 <strong>*</strong></th>
                <td colspan="3"><input type="text" name="account_name" class="form-control xs"
                                       value="${account.name}" placeholder="거래처명을 입력해주세요."></td>
            </tr>
            <tr>
                <th>사업자번호</th>
                <td><input type="text" id="business_number" name="business_number" class="form-control xs"
                           value="${account.business.businessNumber}"></td>
                <th>대표</th>
                <td><input type="text" name="ceo" class="form-control xs" value="${account.ceo}"></td>
            </tr>
            <tr>
                <th>업종</th>
                <td><input type="text" name="business_type" class="form-control xs"
                           value="${account.business.businessType}"></td>
                <th>업태</th>
                <td><input type="text" name="business_category" class="form-control xs"
                           value="${account.business.businessCategory}"></td>
            </tr>
            <tr>
                <th>전화</th>
                <td><input type="text" name="tel" class="form-control xs" value="${account.tel}"></td>
                <th>Fax</th>
                <td><input type="text" name="fax" class="form-control xs" value="${account.fax}"></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td colspan="3"><input type="text" name="email" class="form-control xs"
                                       value="${account.email}"></td>
            </tr>
            <tr>
                <th rowspan="3">주소 1</th>
                <td colspan="3">
                    <input type="text" name="zip_code_1" class="form-control xs w-100"
                           value="${account.address1.zipCode}" style="background-color: #e5e5e5" readonly>
                    <button type="button" id="btnAddressSearch1" class="btn btn-xs">
                        <i class="fa fa-search" aria-hidden="true"></i>
                        주소찾기
                    </button>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="text" name="address_1" class="form-control xs"
                           value="${account.address1.address}" style="background-color: #e5e5e5" readonly>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="text" name="address_detail_1" class="form-control xs"
                           value="${account.address1.addressDetail}">
                </td>
            </tr>
            <tr>
                <th rowspan="3">주소 2</th>
                <td colspan="3">
                    <input type="text" name="zip_code_2" class="form-control xs w-100"
                           value="${account.address2.zipCode}" style="background-color: #e5e5e5" readonly>
                    <button type="button" id="btnAddressSearch2" class="btn btn-xs">
                        <i class="fa fa-search" aria-hidden="true"></i>
                        주소찾기
                    </button>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="text" name="address_2" class="form-control xs"
                           value="${account.address2.address}" style="background-color: #e5e5e5" readonly>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="text" name="address_detail_2" class="form-control xs"
                           value="${account.address2.addressDetail}">
                </td>
            </tr>
            <tr>
                <th>비고</th>
                <td colspan="3"><input type="text" name="etc" class="form-control xs"
                                       value="${account.etc}"></td>
            </tr>
            </tbody>
        </table>

        <div class="mt-1 flex-content-between">
            <button type="button" id="btnBack" class="btn_back btn btn-default">
                <i class="fa fa-arrow-left" aria-hidden="true"></i>
                이전페이지
            </button>

            <c:if test="${account == null and SESSION_CREATE_AUTH eq true}">
                <button type="submit" id="btnQuestionSubmit" class="btn btn-primary">
                    <i class="fa fa-pencil" aria-hidden="true"></i>
                    저장하기
                </button>
            </c:if>
            <c:if test="${account != null and SESSION_UPDATE_AUTH eq true}">
                <button type="submit" id="btnQuestionSubmit" class="btn btn-primary">
                    <i class="fa fa-pencil" aria-hidden="true"></i>
                    수정하기
                </button>
            </c:if>
        </div>
    </form>
</div>

<c:if test="${account != null}">
    <jsp:include page="accountInputFormManagerList.jsp"/>
</c:if>

<script type="text/javascript">


    $(document).ready(function () {
        <c:if test="${account == null}">
        $('input[name="account_code"]').val(makeRandomCode('A_', 5));
        </c:if>

        $('form[name="account-form"]').validate({
            rules: {
                account_name: "required"
            }, messages: {
                account_name: "거래처명을 입력해 주세요."
            }
        });

        $('#btnAddressSearch1').on('click', function (e) {
            getAddressSearch(['zip_code_1', 'address_1', 'address_detail_1'], 'account-form');
        });
        $('#btnAddressSearch2').on('click', function (e) {
            getAddressSearch(['zip_code_2', 'address_2', 'address_detail_2'], 'account-form');
        });
        $('#btnBack').on('click', function () {
            window.location.href = "/accountList.do";
        });
    });


</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<jsp:include page="../layout/bottom.jsp"/>