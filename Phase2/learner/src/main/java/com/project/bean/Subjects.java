package com.project.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="subjects")
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;
	@Column(name = "subjectCode")
	private String subjectCode;
	@Column(name = "subjectName")
	private String subjectName;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private String createdDate;
	
	
	
	
	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Subjects( String subjectCode, String subjectName) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}



	public int getSubjectId() {
		return subjectId;
	}



	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}



	public String getSubjectCode() {
		return subjectCode;
	}



	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}



	public String getSubjectName() {
		return subjectName;
	}



	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	@Override
	public String toString() {
		return "Subjects [subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName
				+ "]";
	}
	
	
}
