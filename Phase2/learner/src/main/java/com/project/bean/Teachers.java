package com.project.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="teachers")
public class Teachers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	@Column(name = "teacherId")
	private String teacherId;
	@Column(name = "teacherName")
	private String teacherName;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private String createdDate;
	
	
	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teachers(String teacherId, String teacherName) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}
	
	
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
		return "Teachers [teacherId=" + teacherId + ", teacherName=" + teacherName + "]";
	}
	
	
}
