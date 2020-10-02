package com.simplelearn.businesslogic;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class BusinessLogicImpl implements BusinessLogic {

	Utility util = new Utility();

	@Override
	public void fileNameList(File folder) {
		// TODO Auto-generated method stub
		File[] fileArr = folder.listFiles();
		String[] strArr = new String[fileArr.length];

		for (int i = 0; i < fileArr.length; i++) {
			if (fileArr[i].isDirectory()) {
				fileNameList(fileArr[i]);
			} else {
				strArr[i] = fileArr[i].getName();
			}
		}
		Arrays.sort(strArr);
		util.printArr(strArr);

	}

	@Override
	public boolean addFile(String fileName, File defaultFolder) throws IOException {
		// TODO Auto-generated method stub
		boolean result = true;
		File file = new File(defaultFolder + "/" + fileName);
		result = file.createNewFile();
		return result;
	}

	@Override
	public String deleteFile(String fileName, File defaultFolder) throws IOException {
		// TODO Auto-generated method stub
		String result = "";
		File file = new File(defaultFolder + "/" + fileName);
		if (file.exists()) {
			if (file.delete())
				result = "File Deleted Succefully";
			else
				result = "File not Deleted";
		} else {
			result = "File not found";
		}
		return result;
	}

	@Override
	public String[] searchFile(String fileName, File defaultFolder) {
		// TODO Auto-generated method stub
		
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept (File dir, String name) {
				return name.equalsIgnoreCase(fileName);
			}
		};
		String [] strArr = defaultFolder.list(filter);
				
		return strArr;
	}

}
