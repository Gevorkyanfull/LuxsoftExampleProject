package com.guzichenko.view;

import com.guzichenko.Utils.IBufferReader;
import com.guzichenko.exceptions.BusinessException;

import java.io.BufferedReader;
import java.io.IOException;

public class MainMenu {

	private final IBufferReader br;
	private final AdminMenu adminMenu;
	private final ClientMenu clientMenu;

	public MainMenu(IBufferReader br, AdminMenu adminMenu, ClientMenu clientMenu) {
		this.br = br;
		this.adminMenu = adminMenu;
		this.clientMenu = clientMenu;
	}

	public void showMenu() throws IOException, BusinessException {
		boolean isRunning = true;
		while (isRunning) {

			System.out.println("1. Admin");
			System.out.println("2. Client");
			System.out.println("0. Exit");

			switch (br.readString()) {
				case "1":
					adminMenu.show();
					break;
				case "2":
					clientMenu.show();
					break;
				case "0":
					isRunning = false;
					break;
				default:
					System.out.println("Wrong input!!!");
					break;
			}
		}

	}
}