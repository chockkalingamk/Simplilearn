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
@Entity
public class Subjects2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;
	@Column(name = "subjectCode")
	private String subjectCode;
	@Column(name = "subjectName")
	private String subjectName;
	
	
	
	
	
	public Subjects2() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Subjects2( String subjectCode, String subjectName) {
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



	
	@Override
	public String toString() {
		return "Subjects [subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName
				+ "]";
	}
	
	
}
