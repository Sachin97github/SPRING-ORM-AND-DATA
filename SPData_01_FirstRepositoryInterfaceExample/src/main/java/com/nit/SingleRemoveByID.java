package com.nit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.dto.ProjectDTO;
import com.nit.service.ProjectMgmtService;

@SpringBootApplication
public class SingleRemoveByID {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ProjectMgmtService service = null;
	

		ctx = SpringApplication.run(SingleRemoveByID.class, args);
		service = ctx.getBean("projectService", ProjectMgmtService.class);

		try {
			System.out.println(service.removeById(10));
		} catch (DataAccessException es) {
			es.printStackTrace();
		}

		((ConfigurableApplicationContext) ctx).close();

	}

}
