package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.dto.ProjectDTO;
import com.nit.entity.Project;
import com.nit.repo.ProjectCustomRepo;

@Service("projectService")
public class ProjectMgmtServiceImpl implements ProjectMgmtService {

	@Autowired
	private ProjectCustomRepo custRepo;

	@Override
	public List<ProjectDTO> sortProjectsByPropety(String property, boolean asc) {

		Iterable<Project> listEntities = null;
		List<ProjectDTO> listDTO = new ArrayList();

		listEntities = custRepo.findAll(Sort.by(asc ? Direction.ASC : Direction.DESC, property));
		listEntities.forEach(source -> {
			ProjectDTO target = new ProjectDTO();
			BeanUtils.copyProperties(source, target);
			listDTO.add(target);
		});//forEach
		return listDTO;
	}

	@Override
	public List<ProjectDTO> sortProjectByProperties(boolean asc, String... properties) {
		Iterable<Project> listEntities = null;
		List<ProjectDTO> listDTO = new ArrayList();

		listEntities = custRepo.findAll(Sort.by(asc ? Direction.ASC : Direction.DESC, properties));
		listEntities.forEach(source -> {
			ProjectDTO target = new ProjectDTO();
			BeanUtils.copyProperties(source, target);
			listDTO.add(target);
		});//forEach
		return listDTO;
	}

	@Override
	public List<ProjectDTO> findProjectwithPageSizeAndNumber(int pageNumber, int pageSize) {

		Iterable<Project> listEntities = null;
		List<ProjectDTO> listDTO = new ArrayList();		
		Pageable pageable=null;
		
		pageable=PageRequest.of(pageNumber,pageSize);
     	Page page= custRepo.findAll(pageable);
     	System.out.println("Page Number :: "+page.getNumber()+"\n TotalPages :: "+page.getTotalPages()+"\n  Size :: "+page.getSize()+"\n Elements ::  "+page.getTotalElements());
     	
     	listEntities=page.getContent();
     	
    	listEntities.forEach(source -> {
			ProjectDTO target = new ProjectDTO();
			BeanUtils.copyProperties(source, target);
			listDTO.add(target);
		});//forEach
		return listDTO;
	}

}
