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
public class ProcedureWithCursor {

	private static CustomerJPARepository custJPARepo;

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EntityManager manager = null;

		ctx = SpringApplication.run(ProcedureWithCursor.class, args);
		manager = ctx.getBean(EntityManager.class);

		StoredProcedureQuery query = manager.createStoredProcedureQuery("GET_CUSTOMER_BY_ADDRESS");
           //Set Type For Parameters
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR);
        //Set value
		query.setParameter(1,"Address10");
		
		try {

			List<Object[]> list = query.getResultList();
			System.out.println("Executed Query");

			list.forEach(row -> {
				for (Object val : row) {
					System.out.println(val + " ");
              	}//enhanced for loop
				});//for Each

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		((ConfigurableApplicationContext) ctx).close();

	}

}
