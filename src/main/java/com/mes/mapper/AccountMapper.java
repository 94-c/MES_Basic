package com.mes.mapper;

import com.mes.data.dto.AccountDto;

import javax.servlet.http.HttpServletRequest;

public class AccountMapper {

    public static AccountDto mapToCreate(HttpServletRequest request) {
        return AccountDto.builder()
                .code(request.getParameter("account_code"))
                .name(request.getParameter("account_name"))
                .businessNumber(request.getParameter("business_number"))
                .businessCategory(request.getParameter("business_category"))
                .businessType(request.getParameter("business_type"))
                .type(request.getParameter("type"))
                .tel(request.getParameter("tel"))
                .ceo(request.getParameter("ceo"))
                .fax(request.getParameter("fax"))
                .email(request.getParameter("email"))
                .zipCode1(request.getParameter("zip_code_1"))
                .address1(request.getParameter("address_1"))
                .addressDetail1(request.getParameter("address_detail_1"))
                .zipCode2(request.getParameter("zip_code_2"))
                .address2(request.getParameter("address_2"))
                .addressDetail2(request.getParameter("address_detail_2"))
                .etc(request.getParameter("etc"))
                .deleteStatus(0)
                .build();
    }
}
