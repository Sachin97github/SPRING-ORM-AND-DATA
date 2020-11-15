package com.nit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.repo.CustomerJPARepository;

@SpringBootApplication
public class UserAuthenticationTestWithProcedure {

	private static CustomerJPARepository custJPARepo;

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EntityManager manager = null;

		ctx = SpringApplication.run(UserAuthenticationTestWithProcedure.class, args);
		manager = ctx.getBean(EntityManager.class);
      
		StoredProcedureQuery query=manager.createStoredProcedureQuery("USER_AUTHENTICATION");
		   query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		   query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		   query.registerStoredProcedureParameter(3,String.class,ParameterMode.OUT);
		   
		   query.setParameter(1,"SACHIN");
		   query.setParameter(2,"SACHINEHA");

		try {
                 String result=(String) query.getOutputParameterValue(3);
                 System.out.println("Output "+result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		((ConfigurableApplicationContext) ctx).close();

	}

}
