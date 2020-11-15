package com.nit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.dto.CustomerDTO;
import com.nit.service.CustomerMgmtService;

@SpringBootApplication
public class BatchInsertionTEST {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
	    CustomerMgmtService service=null;
	    CustomerDTO dto=null;
	    
	    ctx = SpringApplication.run(BatchInsertionTEST.class, args);
        service=ctx.getBean("service",CustomerMgmtService.class);
	    
        try{
        	  service.fetchRecordsSortedPaginated(3);
            System.out.println("DONE");	  
        }
        catch(DataAccessException e)
        {
        	e.printStackTrace();
        }
	    
        ((ConfigurableApplicationContext) ctx).close();
	  
	}

}
