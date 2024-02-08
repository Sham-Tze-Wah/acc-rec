package com.practice.accrec.repositories;

import com.practice.accrec.entities.CustomerInfo;
import com.practice.accrec.entities.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInfoRepo extends BaseEntityRepo<CustomerInfo>{

    @Query("select c from CustomerInfo c where c.deleted = false")
    public List<CustomerInfo> getAllCustomerInfos();

    @Query("select c from CustomerInfo c where c.id = ?1 and c.deleted = false")
    public CustomerInfo getCustomerInfoById(String id);
}
