package com.nit;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.dto.ProjectDTO;
import com.nit.service.ProjectMgmtService;

@SpringBootApplication
public class FetchSingleData {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ProjectMgmtService service = null;
		 Optional<ProjectDTO>  optDTO=null;
	

		ctx = SpringApplication.run(FetchSingleData.class, args);
		service = ctx.getBean("projectService", ProjectMgmtService.class);

	/*	try {
	         optDTO=service.fetchProjectById(2);
	         if(!optDTO.isEmpty())
			        System.out.println(optDTO.get());
	         else
	        	 System.out.println("Record not found");
		} catch (DataAccessException es) {
			es.printStackTrace();
		}*/

		((ConfigurableApplicationContext) ctx).close();

	}

}
