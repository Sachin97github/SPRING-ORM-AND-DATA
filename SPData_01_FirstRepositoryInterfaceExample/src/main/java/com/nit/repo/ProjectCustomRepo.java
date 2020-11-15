package com.nit.repo;

import org.springframework.data.repository.CrudRepository;

import com.nit.entity.Project;

public interface ProjectCustomRepo extends CrudRepository<Project, Integer> {
}
