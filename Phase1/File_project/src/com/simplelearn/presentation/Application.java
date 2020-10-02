package com.simplelearn.presentation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.simplelearn.businesslogic.BusinessLogicImpl;
import com.simplelearn.businesslogic.Utility;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("*********************************************");
		System.out.println("         Welcome to File Utility             ");
		System.out.println("                by                           ");
		System.out.println("          Chockkalingam Kathiresan           ");
		System.out.println("*********************************************");
		System.out.println("\n\n");
		System.out.println("Menu Options");
		int ch = 0, ch1 = 0;
		File defautFolder = new File("TestFolder");
		MenuOptions menuOptions = new MenuOptionsImpl();
		BusinessLogicImpl businessObj = new BusinessLogicImpl();
		Utility util =new Utility();

		do {
			menuOptions.printMenu(menuOptions.menuList());
			System.out.println("Please enter your appropriate choice(1-3)");
			Scanner sc = new Scanner(System.in);
			try {

				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {

			}
			switch (ch) {
			case 1:
				businessObj.fileNameList(defautFolder);

				break;
			case 2:
				menuOptions.printMenu(menuOptions.secondMenuList());
				System.out.println("Please enter your appropriate choice(1-3)");
				try {
					ch1 = Integer.parseInt(sc.nextLine());

					switch (ch1) {
					case 1:
						System.out.println("Enter a file Name with the Extension");
						String fileName = sc.nextLine();
						if (businessObj.addFile(fileName, defautFolder))
							System.out.println("File Created Successfully");
						else
							System.out.println("File not created");
						break;
					case 2:
						System.out.println("Enter a file Name with the Extension");
						String file = sc.nextLine();
						String result= businessObj.deleteFile(file, defautFolder);
						System.out.println(result);
						break;
					case 3:
						System.out.println("Enter a file Name with the Extension to search");
						String fileSearch = sc.nextLine();
						String[] resultSearch= businessObj.searchFile(fileSearch, defautFolder);
						if(resultSearch.length != 0)
							util.printArr(resultSearch);
						else
							System.out.println("No File Name is not present");
						break;
					case 4:
						System.out.println("Back to the Main Menu");

						break;

					}
				} catch (NumberFormatException | IOException e) {

				}
				break;
			case 3:
				System.out.println("Closing the Application");
				System.exit(0);
			default:
				System.out.println("Invalid Choice... Choice should and must be between 1-3 only");
				break;
			}
		} while (ch != 3);

	}

}
