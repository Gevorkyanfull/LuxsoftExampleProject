package com.guzichenko.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guzichenko.dao.ClientDao;
import com.guzichenko.domain.Client;

public class ClientDaoImpl implements ClientDao {

	private static ClientDao clientDao = null;

	private Map<Long, Client> map = new HashMap<>();
	private static long generator = 1;

	private ClientDaoImpl() {
	}

	@Override
	public boolean saveClient(Client client) {
		System.out.println("Saving.... Please wait");
		client.setId(generator++);
		map.put(client.getId(), client);
		return true;
	}

	@Override
	public List<Client> getAllClients() {

		return new ArrayList<>(map.values());
	}

	@Override
	public ArrayList<Integer> getAllPhones() {
		return null;
	}


	public static ClientDao getInstance() {
		if(clientDao == null){
			clientDao=new ClientDaoImpl();
		}
		return clientDao;
	}

}