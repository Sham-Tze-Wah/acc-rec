package com.practice.accrec.repositories;

import com.practice.accrec.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseEntityRepo<T extends BaseEntity> extends org.springframework.data.jpa.repository.JpaRepository<T, String>, org.springframework.data.jpa.repository.JpaSpecificationExecutor<T>{
}
