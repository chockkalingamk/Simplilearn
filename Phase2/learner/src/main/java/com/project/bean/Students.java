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
@Table(name = "students")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	@Column(name = "studentId")
	private String studentId;
	@Column(name = "studentName")
	private String studentName;
	@ManyToOne
	@JoinColumn(name = "classId")
	private Classes classes;
	
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private String createdDate;
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(String studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
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
		return "Students [sId=" + sId + ", studentId=" + studentId + ", studentName=" + studentName + ", classes="
				+ classes + "]";
	}
	
	
	
	
}
