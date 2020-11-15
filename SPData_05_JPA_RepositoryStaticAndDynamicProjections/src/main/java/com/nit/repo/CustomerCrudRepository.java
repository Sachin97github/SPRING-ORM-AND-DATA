package com.nit.repo;

import org.springframework.data.repository.CrudRepository;

import com.nit.entity.Customer;

public interface CustomerCrudRepository extends CrudRepository<Customer,Integer> {

}
