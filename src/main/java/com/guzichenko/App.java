package com.guzichenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.guzichenko.Utils.BufferReaderUtils;
import com.guzichenko.Utils.IBufferReader;
import com.guzichenko.dao.Dao;
import com.guzichenko.dao.impl.ClientDaoImpl;
import com.guzichenko.dao.impl.ProductDaoImpl;
import com.guzichenko.domain.Client;
import com.guzichenko.domain.Product;
import com.guzichenko.exceptions.BusinessException;
import com.guzichenko.services.ClientService;
import com.guzichenko.services.ProductData;
import com.guzichenko.services.ProductService;
import com.guzichenko.services.impl.ClientServiceImpl;
import com.guzichenko.services.impl.ProductServiceImpl;
import com.guzichenko.validators.ValidationService;
import com.guzichenko.validators.impl.ValidationServiceImpl;
import com.guzichenko.view.AdminMenu;
import com.guzichenko.view.ClientMenu;
import com.guzichenko.view.MainMenu;

public class App {

	public static void main(String[] args) throws IOException, BusinessException {

		Dao<Client> clientDao = ClientDaoImpl.getInstance();
		Dao<Product> productDao= ProductDaoImpl.getInstance();
		ValidationService validationService = new ValidationServiceImpl();
		ClientService clientService = new ClientServiceImpl(clientDao, validationService);
		ProductService productService=new ProductServiceImpl(validationService, productDao);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		IBufferReader reader = new BufferReaderUtils(br);

		AdminMenu adminMenu = new AdminMenu(reader, clientService,productService);
		ClientMenu clientMenu = new ClientMenu(reader, clientService);
		MainMenu menu = new MainMenu(reader, adminMenu, clientMenu);

		menu.showMenu();
	}
}