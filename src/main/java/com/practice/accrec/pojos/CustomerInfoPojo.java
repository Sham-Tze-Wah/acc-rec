package com.practice.accrec.pojos;

import com.practice.accrec.utils.Global;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CustomerInfoPojo {
    private String mxName;
    private String mxIdNo;
    private String mxHandPhoneNo;
    private String mxEmail;
    private String mxLoginId;
    private String mxAccountId;
    private String extendedInfo;
    private String mxNationality;
    private String mxAddress;
    private String mxAddress2;
    private String mxAddress3;
    private String mxAddress4;
    private String mxCity;
    private String mxPostcode;
    private String mxState;
    private String mxCountry;
}
