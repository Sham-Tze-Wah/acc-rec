package com.practice.accrec.repositories.impl;


import com.practice.accrec.entities.BaseEntity;
import com.practice.accrec.repositories.BaseEntityRepo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;

public class BaseEntityRepoImpl<T extends BaseEntity> extends SimpleJpaRepository<T, String>
        implements org.springframework.data.jpa.repository.JpaRepository<T, String>, org.springframework.data.jpa.repository.JpaSpecificationExecutor<T>,
        BaseEntityRepo<T> {

    public BaseEntityRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }
}
