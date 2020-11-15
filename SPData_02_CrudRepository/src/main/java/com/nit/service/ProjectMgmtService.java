package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.dto.ProjectDTO;
import com.nit.entity.Project;

public interface ProjectMgmtService {

	public String register(Project entity);
	public String removeById(Integer proId);
	public String registerGroupProject(List<ProjectDTO> llistDTO);
	public String removeGroupProject(List<ProjectDTO> listDTO);
	public List<ProjectDTO> fetchAllProject();
	public String fetchAllProjectCount();
	public String removeAllProject();
	public Optional<ProjectDTO> fetchProjectById(Integer proId);
	public List<ProjectDTO> fetchProjectsByIds(List<Integer>ids);
	
}
