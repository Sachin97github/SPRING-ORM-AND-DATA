package com.nit.dto;

import java.io.Serializable;

public class ProjectDTO implements Serializable {

	private Integer projId;
	private String projName;
	private String compony;
	private Double cost;

	
	
	public ProjectDTO() {
		super();
	
	}

	public ProjectDTO(Integer projId) {
		super();
		this.projId = projId;
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getCompony() {
		return compony;
	}

	public void setCompony(String compony) {
		this.compony = compony;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", compony=" + compony + ", cost=" + cost + "]";
	}

	
}
