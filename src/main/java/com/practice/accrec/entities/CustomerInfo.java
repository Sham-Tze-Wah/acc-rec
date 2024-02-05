package com.practice.accrec.entities;

import com.practice.accrec.utils.Global;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false, exclude = {"refundCaseInfo"})
@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerInfo {
    private static final long serialVersionUID = -6946728522454892341L;

    @Column(name = "CUSTOMER_NAME",nullable = false, length = Global.VARCHAR100)
    private String mxName;

    @Column(name = "CUSTOMER_ID_NO", length = Global.VARCHAR50)
    private String mxIdNo;

    @Column(name = "CUSTOMER_HAND_PHONE_NO", length = Global.VARCHAR50)
    private String mxHandPhoneNo;

    @Column(name = "CUSTOMER_EMAIL", length = Global.VARCHAR100)
    private String mxEmail;

    @Column(name = "CUSTOMER_LOGIN_ID", length = Global.VARCHAR100)
    private String mxLoginId;

    @Column(name = "CUSTOMER_ACCOUNT_ID", length = Global.VARCHAR100)
    private String mxAccountId;

    @Column(name = "EXTENDED_INFO", columnDefinition = "LONGTEXT")
    private String extendedInfo;

    @Column(name = "CUSTOMER_NATIONALITY", length = Global.VARCHAR255)
    private String mxNationality;

    @Column(name="CUSTOMER_ADDRESS",length = Global.VARCHAR100)
    private String mxAddress;

    @Column(name="CUSTOMER_ADDRESS2",length = Global.VARCHAR100)
    private String mxAddress2;

    @Column(name="CUSTOMER_ADDRESS3",length = Global.VARCHAR100)
    private String mxAddress3;

    @Column(name="CUSTOMER_ADDRESS4",length = Global.VARCHAR100)
    private String mxAddress4;

    @Column(name="CUSTOMER_CITY",length = Global.VARCHAR50)
    private String mxCity;

    @Column(name="CUSTOMER_POSTCODE",length = Global.VARCHAR50)
    private String mxPostcode;

    @Column(name="CUSTOMER_STATE",length = Global.VARCHAR50)
    private String mxState;

    @Column(name="CUSTOMER_COUNTRY",length = Global.VARCHAR100)
    private String mxCountry;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn
//    private IdentificationType mxIdType;
}
