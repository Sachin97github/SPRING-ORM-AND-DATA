package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.repo.CustomerJPARepository;
import com.nit.repo.CustomerJPARepository.ResultView;
import com.nit.repo.CustomerJPARepository.ResultView2;



@SpringBootApplication
public class ProjectionDynamicTEST {

	private static CustomerJPARepository custJPARepo;
	
	public static void main(String[] args) {
		ApplicationContext ctx = null;
	     ResultView rv=null;
	    
	    ctx = SpringApplication.run(ProjectionDynamicTEST.class, args);
        custJPARepo=ctx.getBean(CustomerJPARepository.class);
        System.out.println(custJPARepo.getClass().getName());
	    
        try{
        	List<ResultView> viewList=custJPARepo.findByCusAddress(ResultView.class,"Address10");
            for(ResultView v :viewList)
        	{
                System.out.println("Name - "+v.getCusName()+" Bill - "+v.getBillAmt());                
        	}
        	
            //Same Method with Different ResultView
            List<ResultView2> viewList2=custJPARepo.findByCusAddress(ResultView2.class,"Address10");
            for(ResultView2 v :viewList2)
        	{
                System.out.println("Id - "+v.getCusId()+" Name - "+v.getCusName()+" Bill - "+v.getBillAmt());                
        	}
          
            //Here it can Hold any class name at Runtime it might cause Class cast exception 
            //to avoid this Exception we have to modify Generics So it can hold Only those classes/Interface which are Extending View(Interface)
            //<T extends Vew> List<T> findByCusAddress(Class<T> clazz,String addr);
                     //Now it can hold only those values which are Entending View not any other class          
            //custJPARepo.findByCusAddress(String.class,"Address10");
            }
        catch(DataAccessException e)
        {
        	e.printStackTrace();
        }
	    
        ((ConfigurableApplicationContext) ctx).close();
	  
	}

}
