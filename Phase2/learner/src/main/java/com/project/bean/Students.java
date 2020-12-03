package com.project.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	@Column(name = "studentName")
	private String studentName;
	@Column(name = "classId")
	private int classId;
}
