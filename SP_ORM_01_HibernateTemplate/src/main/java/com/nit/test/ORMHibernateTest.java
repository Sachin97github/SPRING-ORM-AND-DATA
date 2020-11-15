package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.dto.ProductDTO;
import com.nit.service.ProductMgmtService;

public class ORMHibernateTest {

	public static void main(String[] args) {
		   ApplicationContext ctx=null;
		   ProductMgmtService  service=null;
		   ProductDTO dto=null;
		   //create IOC container
		   ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		   
		   //get Service class object
		   service=ctx.getBean("prdMgmtService",ProductMgmtService.class);
		   //save object
		 try {
		   //create DTO
		    dto=new ProductDTO();
		    
		    dto.setpName("WHATSAPP");
		    dto.setQty(23);
		    dto.setPrice(452222d);
		    
		   System.out.println(service.addProduct(dto));
		}
		catch(DataAccessException dae) {
		   dae.printStackTrace();
		}
	
	//close container
		   ((AbstractApplicationContext) ctx).close();

	}//main
}//class
