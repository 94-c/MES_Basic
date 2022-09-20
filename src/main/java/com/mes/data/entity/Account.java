package com.mes.data.entity;

import com.mes.data.model.Address;
import com.mes.data.model.Business;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "accounts_code")
    private String code;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Embedded
    private Business business;

    @Column(name = "ceo")
    private String ceo;

    @Column(name = "tel")
    private String tel;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code1")),
            @AttributeOverride(name = "address", column = @Column(name = "address1")),
            @AttributeOverride(name = "addressDetail", column = @Column(name = "address_detail1"))
    })
    private Address address1;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code2")),
            @AttributeOverride(name = "address", column = @Column(name = "address2")),
            @AttributeOverride(name = "addressDetail", column = @Column(name = "address_detail2"))
    })
    private Address address2;

    @Column(name = "etc")
    private String etc;

    @Column(name = "delete_status")
    private Integer deleteStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    public List<AccountManager> accountManagers;*/
}
