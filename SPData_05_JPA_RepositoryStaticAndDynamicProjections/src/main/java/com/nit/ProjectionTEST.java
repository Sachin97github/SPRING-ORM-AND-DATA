package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.repo.CustomerJPARepository;
import com.nit.repo.CustomerJPARepository.ResultView;



@SpringBootApplication
public class ProjectionTEST {

	private static CustomerJPARepository custJPARepo;
	
	public static void main(String[] args) {
		ApplicationContext ctx = null;
	     ResultView rv=null;
	    
	    ctx = SpringApplication.run(ProjectionTEST.class, args);
        custJPARepo=ctx.getBean(CustomerJPARepository.class);
        System.out.println(custJPARepo.getClass().getName());
	    
        try{
        	List<ResultView> viewList=custJPARepo.findByCusAddress("Address10");
            viewList.forEach(view->{
            	System.out.println("Customer name :: "+view.getCusName()+" Bill Amount :: "+view.getBillAmt()+" Class :: "+view.getClass());
               //System.out.println(view); it will print Hashcode
            });
           }
        catch(DataAccessException e)
        {
        	e.printStackTrace();
        }
	    
        ((ConfigurableApplicationContext) ctx).close();
	  
	}

}
