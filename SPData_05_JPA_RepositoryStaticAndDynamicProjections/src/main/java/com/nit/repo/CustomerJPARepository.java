package com.nit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Customer;

public interface CustomerJPARepository extends JpaRepository<Customer,Integer> {
	
	interface View
	{
	
	}
	
	
	//When you want only specific values to be fetched
	 interface ResultView extends View
     {
    	 String getCusName();
    	 String  getBillAmt();
     }
	 interface ResultView2 extends View
	 {
		 Integer getCusId();
		 String getCusName();
		 String  getBillAmt();
		}
    
	 //Here we can not change view dynamically
	 //Static Projection
     List<ResultView> findByCusAddress(String addr);
     
     //We can chose Which ResultView has to be used
     <T extends View> List<T> findByCusAddress(Class<T> clazz,String addr);
     
    
     
}
