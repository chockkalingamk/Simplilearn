package com.simplelearn.businesslogic;

import java.io.File;
import java.io.IOException;

public interface BusinessLogic {
	
	public void fileNameList(File file);
	
	public boolean addFile(String fileName, File defaultFolder)throws IOException;
	
	public String deleteFile(String fileName, File defaultFolder)throws IOException;
	
	public String[] searchFile(String fileName, File defaultFolder);

}
