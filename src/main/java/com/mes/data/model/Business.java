package com.mes.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Business {

    @Column(name = "business_number", unique = false)
    private String businessNumber;

    @Column(name = "business_type")
    private String businessType;

    @Column(name = "business_category")
    private String businessCategory;

    public Business() {
    }

    public Business(String businessNumber, String businessType, String businessCategory) {
        this.businessNumber = businessNumber;
        this.businessType = businessType;
        this.businessCategory = businessCategory;
    }
}
