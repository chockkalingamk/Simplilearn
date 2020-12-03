package com.project.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;
	@Column(name = "subjectCode")
	private String subjectCode;
	@Column(name = "subjectName")
	private String subjectName;
	@Column(name = "classId")
	private int classId;
}
