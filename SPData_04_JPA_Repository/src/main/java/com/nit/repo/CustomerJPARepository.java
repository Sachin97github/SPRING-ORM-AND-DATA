package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Customer;

public interface CustomerJPARepository extends JpaRepository<Customer,Integer> {

}
