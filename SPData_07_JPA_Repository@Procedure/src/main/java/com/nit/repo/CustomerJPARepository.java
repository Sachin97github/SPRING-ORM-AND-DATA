package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nit.entity.Customer;

@Transactional
public interface CustomerJPARepository extends JpaRepository<Customer,Integer> {
	
   
	
	
}
