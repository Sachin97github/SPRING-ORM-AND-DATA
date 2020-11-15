package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.dto.ProjectDTO;
import com.nit.entity.Project;

public interface ProjectMgmtService {
	public List<ProjectDTO> sortProjectsByPropety(String property,boolean asc);
	public List<ProjectDTO> sortProjectByProperties(boolean asc,String ... properties);
	
	public List<ProjectDTO> findProjectwithPageSizeAndNumber(int pageNumber,int pageSize);
}
