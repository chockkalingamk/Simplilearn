package com.simplelearn.presentation;

import java.util.Scanner;

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
		int ch = 0;
		MenuOptions menuOptions = new MenuOptionsImpl();

		do {
			menuOptions.printMenu(menuOptions.menuList());
			System.out.println("Please enter your appropriate choice(1-3)");
			try {
				Scanner sc = new Scanner(System.in);
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {

			}
			switch (ch) {
			case 1:
				System.out.println("This option is under construction thankq for your interest here.....");

				break;
			case 2:
				menuOptions.printMenu(menuOptions.secondMenuList());
				System.out.println("Please enter your appropriate choice(1-3)");
				try {
					Scanner sc1 = new Scanner(System.in);
					ch = Integer.parseInt(sc1.nextLine());
				} catch (NumberFormatException e) {

				}
				switch (ch) {
				case 1:
					System.out.println("Add a file to the directory");

					break;
				case 2:
					System.out.println("Delete a file from the directory");

					break;
				case 3:
					System.out.println("Search a file from the directory");

					break;
				case 4:
					System.out.println("Back to the Main Menu");

					break;

				}
				break;
			case 3:
				System.out.println("Closing the Application");

				break;
			default:
				System.out.println("Invalid Choice... Choice should and must be between 1-4 only");
				break;
			}
		} while (ch != 3);

		menuOptions.printMenu(menuOptions.secondMenuList());
	}

}
