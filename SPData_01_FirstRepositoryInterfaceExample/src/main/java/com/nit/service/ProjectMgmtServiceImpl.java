package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dto.ProjectDTO;
import com.nit.entity.Project;
import com.nit.repo.ProjectCustomRepo;

@Service("projectService")
public class ProjectMgmtServiceImpl implements ProjectMgmtService {

	@Autowired
	private ProjectCustomRepo custRepo;

	@Override
	public String register(Project entity) {

		Project proj = null;
		proj = custRepo.save(entity);

		return proj != null ? "Object Saved " + proj : "Object not Saved";

	}

	@Override
	public String registerGroupProject(List<ProjectDTO> listDTO) {
		List<Project> presistableListEntities = new ArrayList();
		List<Project> returnedListEntities = null;
		String ids = null;
		listDTO.forEach(dto -> {
			Project project = new Project();
			BeanUtils.copyProperties(dto, project);
			presistableListEntities.add(project);
		});
		// it will return List of Persisted Object
		returnedListEntities = (List<Project>) custRepo.saveAll(presistableListEntities);
		// it will represent only Ids of every OBject that has been pesisted
		ids = returnedListEntities.stream().map(e -> e.getProjId()).collect(Collectors.toList()).toString();
		return returnedListEntities != null ? "Projects Saved with having these Ids :: " + ids : "Projects not saved";
	}

	@Override
	public String removeById(Integer id) {
		Boolean flag;
		flag = custRepo.existsById(id);
		if (flag)
			custRepo.deleteById(id);
		return flag ? "Project Deleted with id " + id : "Project not exists with id " + id;

	}

	@Override
	public String removeGroupProject(List<ProjectDTO> listDTO) {
		List<Project> listProj = new ArrayList();

		listDTO.forEach(dto -> {
			Project project = new Project();
			BeanUtils.copyProperties(dto, project);
			listProj.add(project);
		});
		custRepo.deleteAll(listProj);
		return "Batch Deletion Succeded";

	}

	@Override
	public List<ProjectDTO> fetchAllProject() {
		Iterable<Project> itEntities = null;
		List<ProjectDTO> listDTO = new ArrayList();

		itEntities = custRepo.findAll();
		itEntities.forEach(entity -> {
			ProjectDTO dto = new ProjectDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});

		return listDTO;
	}

	@Override
	public String fetchAllProjectCount() {
         Long count=null;  
         //returns 0 if no projects are there
         count=custRepo.count();
		return count!=0?count+" Projects are Available":"No Project are there to display";
	}

	@Override
	public String removeAllProject() {
		custRepo.deleteAll();
		return "ALL PROJECTS ARE DELETED";
	}

}
