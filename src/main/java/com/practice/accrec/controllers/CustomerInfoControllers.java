package com.practice.accrec.controllers;

import com.practice.accrec.entities.CustomerInfo;
import com.practice.accrec.pojos.CustomerInfoPojo;
import com.practice.accrec.repositories.CustomerInfoRepo;
import com.practice.accrec.services.AppMessagesService;
import com.practice.accrec.utils.AppMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerInfoControllers {

    private static final String ENTITY_NAME = "customer-info";

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CustomerInfoRepo customerInfoRepo;

    @Autowired
    private AppMessagesService appMessagesService;

    @GetMapping(value = ENTITY_NAME)
//    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN', 'A_GET_ALL_CUSTOMER_INFO')")
    public ResponseEntity<Object> getCustomerInfo() {
        try {
            return new ResponseEntity<>(customerInfoRepo.getAllCustomerInfos(), HttpStatus.OK);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            String appMessages = messageSource.getMessage(AppMessages.UNABLE_TO_FETCH_CUSTOMER_INFO, null, Locale.ENGLISH);
            return new ResponseEntity<>(appMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping(value = ENTITY_NAME + "/{id}")
    public ResponseEntity<Object> getCustomerInfoById(@PathVariable final String id){
        try{
            return new ResponseEntity<>(customerInfoRepo.getCustomerInfoById(id), HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage());
            String appMessages = messageSource.getMessage(AppMessages.UNABLE_TO_FETCH_CUSTOMER_INFO, null, Locale.ENGLISH);
            return new ResponseEntity<>(appMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PostMapping(value = ENTITY_NAME)
    public ResponseEntity<Object> createCustomerInfo(@RequestBody final CustomerInfoPojo customerInfoPojo){
        try{
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setMxName(customerInfoPojo.getMxName());
            customerInfo.setMxIdNo(customerInfoPojo.getMxIdNo());
            customerInfo.setMxHandPhoneNo(customerInfo.getMxHandPhoneNo());
            customerInfo.setMxEmail(customerInfoPojo.getMxEmail());
            customerInfo.setMxLoginId(customerInfoPojo.getMxLoginId());
            customerInfo.setMxAccountId(customerInfoPojo.getMxAccountId());
            customerInfo.setExtendedInfo(customerInfo.getExtendedInfo());
            customerInfo.setMxNationality(customerInfoPojo.getMxNationality());
            customerInfo.setMxAddress(customerInfoPojo.getMxAddress());
            customerInfo.setMxAddress2(customerInfoPojo.getMxAddress2());
            customerInfo.setMxAddress3(customerInfoPojo.getMxAddress3());
            customerInfo.setMxAddress4(customerInfoPojo.getMxAddress4());
            customerInfo.setMxCity(customerInfoPojo.getMxCity());
            customerInfo.setMxPostcode(customerInfoPojo.getMxPostcode());
            customerInfo.setMxState(customerInfoPojo.getMxState());
            customerInfo.setMxCountry(customerInfoPojo.getMxCountry());
            return new ResponseEntity<>(customerInfoPojo, HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage());
            String appMessages = messageSource.getMessage(AppMessages.UNABLE_TO_CREATE_CUSTOMER_INFO, null, Locale.ENGLISH);
            return new ResponseEntity<>(appMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping(ENTITY_NAME+"/{id}")
    public ResponseEntity<Object> updateCustomerInfo(
            @PathVariable final String id,
            @RequestBody final CustomerInfoPojo customerInfoPojo){
        try {
            CustomerInfo customerInfo = customerInfoRepo.getCustomerInfoById(id);
            if(customerInfo==null){
                String appMessages = messageSource.getMessage(AppMessages.UNABLE_TO_UPDATE_CUSTOMER_INFO_DELETED, null, Locale.ENGLISH);
                return new ResponseEntity<>(appMessages,HttpStatus.UNPROCESSABLE_ENTITY);
            }
            customerInfo.setMxName(customerInfoPojo.getMxName());
            customerInfo.setMxIdNo(customerInfoPojo.getMxIdNo());
            customerInfo.setMxHandPhoneNo(customerInfo.getMxHandPhoneNo());
            customerInfo.setMxEmail(customerInfoPojo.getMxEmail());
            customerInfo.setMxLoginId(customerInfoPojo.getMxLoginId());
            customerInfo.setMxAccountId(customerInfoPojo.getMxAccountId());
            customerInfo.setExtendedInfo(customerInfo.getExtendedInfo());
            customerInfo.setMxNationality(customerInfoPojo.getMxNationality());
            customerInfo.setMxAddress(customerInfoPojo.getMxAddress());
            customerInfo.setMxAddress2(customerInfoPojo.getMxAddress2());
            customerInfo.setMxAddress3(customerInfoPojo.getMxAddress3());
            customerInfo.setMxAddress4(customerInfoPojo.getMxAddress4());
            customerInfo.setMxCity(customerInfoPojo.getMxCity());
            customerInfo.setMxPostcode(customerInfoPojo.getMxPostcode());
            customerInfo.setMxState(customerInfoPojo.getMxState());
            customerInfo.setMxCountry(customerInfoPojo.getMxCountry());
            return new ResponseEntity<>(customerInfoPojo, HttpStatus.OK);
        }catch(Exception ex){
            log.error(ex.getMessage());
            String appMessages = messageSource.getMessage(AppMessages.UNABLE_TO_UPDATE_CUSTOMER_INFO, null, Locale.ENGLISH);
            return new ResponseEntity<>(appMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
