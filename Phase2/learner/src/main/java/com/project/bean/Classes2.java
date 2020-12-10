package com.project.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Classes2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classId;
	@Column(name = "className")
	private String className;
	@Column(name = "standardName")
	private String standardName;
	@Column(name = "standardSection")
	private String standardSection;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="subjectId")
	private Subjects subject;
	
	public Classes2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classes2(int classId, String className, String standardName, String standardSection) {
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
