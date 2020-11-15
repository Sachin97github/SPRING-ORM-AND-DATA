package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nit.entity.Customer;

@Transactional
public interface CustomerJPARepository extends JpaRepository<Customer,Integer> {
	
    @Query("FROM Customer")
	Iterable<Customer> getAllCustomers();

	
	  @Query("FROM Customer WHERE cusAddress=?1") Iterable<Customer>
	  getCustomerByAddress(String addr);
	 
    @Query("FROM Customer WHERE billAmt>=?1  AND billAmt<?2")
    Iterable<Customer> getCustomersByBillAmt(Double min,Double max);
     
    @Query("FROM  Customer WHERE cusAddress IN(:city1,:city2,:city3)")
    Iterable<Customer> getCustomersByAddresses(   @Param("city1") String city1,@Param("city2") String city2,@Param("city3") String city3);
    
    @Query("SELECT cusId,cusName,cusAddress FROM Customer WHERE billAmt BETWEEN :min AND :max")
    Iterable<Object[]> getCustomerDetailsByBillRange(@Param("min") Double min,@Param("max")  Double max);
    
    @Query("SELECT cusName,billAmt,cusAddress FROM Customer WHERE cusId=:cusId")
     Object  getCustomerInfoByCusId(Integer cusId);
                        
                                      //Update Operation
    @Modifying 
    @Query("UPDATE Customer SET billAmt=billAmt+:money WHERE cusAddress=:address")
     int  updateBillAmtByCity(Double money,String address); 
    
                                       //Delete Operation
    @Modifying
    @Query("DELETE FROM Customer WHERE cusId=:cusId")
    int deleteCustomerById(Integer cusId);
    
    //-------------------------------------------------Native Query--------------------------------------------------
    @Query(nativeQuery=true,value="SELECT CUS_ADDRESS,CUS_NAME FROM CUSTOMER WHERE CUS_ADDRESS=:address")
    Iterable<Object[]> getCustomerInfoByAddress(String address);
    
    //-------------------------------------------------Native Query Sequnce---------------------------------------------
    @Query(nativeQuery=true,value="CALL GET_CUS_BY_ADDRESS(?)")
    Iterable<Customer> getCusByAddressByProcedure(String address);
    
    
    
    
    
    
     
}
