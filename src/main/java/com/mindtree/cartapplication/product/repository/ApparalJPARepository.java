package com.mindtree.cartapplication.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mindtree.cartapplication.product.repository.entity.Apparal;

public interface ApparalJPARepository extends JpaRepository<Apparal, Integer>, JpaSpecificationExecutor<Apparal> {

}
