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
public class RegisterGroupProject {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ProjectMgmtService service = null;
	

		ctx = SpringApplication.run(RegisterGroupProject.class, args);
		service = ctx.getBean("projectService", ProjectMgmtService.class);
	
		List<ProjectDTO> listDTO=new ArrayList();
		
	for(int i=0;i<=10;i++)
	{
		ProjectDTO dto=new ProjectDTO();
		dto.setProjName("PROJECT"+i);
		dto.setCompony("COMPONY"+i);
		dto.setCost(850000D+i);
		listDTO.add(dto);
	}
		try {
			System.out.println(service.registerGroupProject(listDTO));
		} catch (DataAccessException es) {
			es.printStackTrace();
		}

		((ConfigurableApplicationContext) ctx).close();

	}

}
