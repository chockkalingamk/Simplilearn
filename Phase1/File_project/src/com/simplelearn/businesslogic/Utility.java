package com.simplelearn.businesslogic;

import java.util.List;

public class Utility {

	public void printList(List<String> strList) {
		strList.forEach(str -> System.out.println(str));
	}
	
	public void printArr(String[] strArr) {
		for(String s:strArr) {
			System.out.println(s);
		}
	}

}
