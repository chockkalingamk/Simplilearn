package com.project.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classId;
	@Column(name = "className")
	private String className;
	@Column(name = "standardName")
	private String standardName;
	@Column(name = "standardSection")
	private String standardSection;
	
	
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classes(int classId, String className, String standardName, String standardSection) {
		super();
		this.classId = classId;
		this.className = className;
		this.standardName = standardName;
		this.standardSection = standardSection;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStandardName() {
		return standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	public String getStandardSection() {
		return standardSection;
	}
	public void setStandardSection(String standardSection) {
		this.standardSection = standardSection;
	}
	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", standardName=" + standardName
				+ ", standardSection=" + standardSection + "]";
	}
	
	

}
