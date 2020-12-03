package com.project.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Teachers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teacherId;
	@Column(name = "teacherName")
	private String teacherName;
	@Column(name = "subjectId")
	private int subjectId;
	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teachers(int teacherId, String teacherName) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	@Override
	public String toString() {
		return "Teachers [teacherId=" + teacherId + ", teacherName=" + teacherName + ", subjectId=" + subjectId + "]";
	}
	
	
}