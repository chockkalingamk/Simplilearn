package com.project.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="cls_sub_teh")
public class SubjectsClasses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "classId")
	private Classes classes;

	@ManyToOne
	@JoinColumn(name = "subjectId")
	private Subjects subjects;
	
	@ManyToOne
	@JoinColumn(name = "tId")
	private Teachers teachers;
	
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private String createdDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Subjects getSubjects() {
		return subjects;
	}
	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}
	public Teachers getTeachers() {
		return teachers;
	}
	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "SubjectsClasses [id=" + id + ", classes=" + classes + ", subjects=" + subjects + ", teachers="
				+ teachers + ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
	}
	
	
	
	

}
