package com.nit.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nit.entity.Project;

public interface ProjectCustomRepo extends PagingAndSortingRepository<Project,Integer> {
	
}
