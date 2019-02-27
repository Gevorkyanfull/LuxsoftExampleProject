package com.guzichenko.view;

import java.io.BufferedReader;
import java.io.IOException;

import com.guzichenko.Utils.IBufferReader;
import com.guzichenko.exceptions.BusinessException;
import com.guzichenko.services.ClientData;
import com.guzichenko.services.ClientService;

public class ClientMenu {
	private final IBufferReader br;
	private final ClientService clientService;

	public ClientMenu(IBufferReader br, ClientService clientService) {
		this.br = br;
		this.clientService = clientService;
	}

	public void show() throws IOException, BusinessException {
		while (true) {
			showMenu();
			switch (br.readString()) {
				case "1":
					createClient();
					break;
				case "2":
					System.out.println("Modify client");
					break;
				case "0":
					System.exit(0);
				default:
					System.out.println("Wrong input!!!");
					break;
			}
		}
	}

	private void createClient() throws IOException, BusinessException {
		System.out.println("Create new client:");
		clientService.createClient(inputClientData());
	}

	private void modifyClient() throws IOException {
		System.out.println("Modify client.");
		System.out.println("Input id: ");
		Long id = br.readLong();
		ClientData data = inputClientData();
		clientService.modifyClient(id, data);
	}

	private ClientData inputClientData() throws IOException {
		System.out.println("Input name: ");
		String name = br.readString();
		System.out.println("Input surname: ");
		String surname = br.readString();
		System.out.println("Input phone number: ");
		String phoneNumber = br.readString();
		return new ClientData(name, surname, phoneNumber);
	}

	private void showMenu() {
		System.out.println("1. Register");
		System.out.println("2. Modify"); //by ID
		System.out.println();
		System.out.println("3. List products");
		System.out.println("4. Add order");
		System.out.println("5. List orders");
		System.out.println();
		System.out.println("R. Return");
		System.out.println("E. Exit");
	}

}