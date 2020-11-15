package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.repo.CustomerJPARepository;
import com.nit.service.EmployeeMgmtService;

@SpringBootApplication
public class FunctionCallwithCallableStatement {

	private static CustomerJPARepository custJPARepo;

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeMgmtService service = null;

		ctx = SpringApplication.run(FunctionCallwithCallableStatement.class, args);
		service = ctx.getBean("EmpService", EmployeeMgmtService.class);

		try {
			System.out.println("Before Function Excution");
			service.getEmpInfo(7499);
			System.out.println("After Function Excution");

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		((ConfigurableApplicationContext) ctx).close();

	}

}
