package com.simplelearn.presentation;

import java.util.ArrayList;
import java.util.List;

public class MenuOptionsImpl implements MenuOptions {

	@Override
	public List<String> menuList() {
		List<String> strList = new ArrayList<String>();
		strList.add("List the FileNames");
		strList.add("Add/Delete/Search a File");
		strList.add("Exit the Application");
		return strList;
	}

	@Override
	public void printMenu(List<String> strList) {
		int labelInt = 1;
		for (String str : strList) {
			System.out.println(labelInt + "." + str);
			labelInt++;
		}
	}
	
	public List<String> secondMenuList() {
		List<String> strList = new ArrayList<String>();
		strList.add("Add a File");
		strList.add("Delete a File");
		strList.add("Search a File");
		strList.add("Back to Main Menu");
		return strList;
	}
	

}
