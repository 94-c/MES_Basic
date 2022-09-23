package com.mes.data.dto;

import com.mes.data.entity.Account;
import com.mes.data.model.Address;
import com.mes.data.model.Business;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
public class AccountDto {

    private final Integer id;
    private final String code;
    private final String name;
    private final String businessNumber;
    private final String businessCategory;
    private final String businessType;
    private final String type;
    private final String ceo;
    private final String tel;
    private final String fax;
    private final String email;
    private final String zipCode1;
    private final String address1;
    private final String addressDetail1;
    private final String zipCode2;
    private final String address2;
    private final String addressDetail2;
    private final String etc;
    private final String[] ids;
    private final Integer deleteStatus;
    private final List<Account> accountList;
    private final long totalCount;

    public Account toCreateEntity() {
        Account account = new Account();
        account.setCode(code);
        account.setName(name);
        account.setType(type);
        account.setCeo(ceo);
        account.setTel(tel);
        account.setFax(fax);
        account.setEmail(email);


        Business business = new Business();
        business.setBusinessNumber(businessNumber);
        business.setBusinessType(businessType);
        business.setBusinessCategory(businessCategory);
        account.setBusiness(business);

        Address addressOne = new Address();
        addressOne.setZipCode(zipCode1);
        addressOne.setAddress(address1);
        addressOne.setAddressDetail(addressDetail1);
        account.setAddress1(addressOne);

        Address addressTwo = new Address();
        addressTwo.setZipCode(zipCode2);
        addressTwo.setAddress(address2);
        addressTwo.setAddressDetail(addressDetail2);
        account.setAddress2(addressTwo);

        return account;
    }
}

