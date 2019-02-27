package com.guzichenko.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guzichenko.dao.Dao;
import com.guzichenko.dao.Dao;
import com.guzichenko.domain.Client;
import com.guzichenko.dao.DaoException;

public class ClientDaoImpl implements Dao<Client> {

	private static Dao<Client> clientDao = null;

	private Map<Long, Client> map = new HashMap<>();
	private static long generator = 1;

	private ClientDaoImpl() {
	}

	@Override
	public Long save(Client client) {
		System.out.println("Saving.... Please wait");
		if (!map.containsKey(client.getId())){
			client.setId(generator++);
		}

		map.put(client.getId(), client);
		return client.getId();
	}

	@Override
	public Client get(Long id) {
		return map.get(id);
	}

	@Override
	public List<Client> getAll() {

		return new ArrayList<>(map.values());
	}

	//@Override
	//public ArrayList<Integer> getAllPhones() {
		//return null;
	//}

	@Override
	public void remove(Long id)throws DaoException {
		if (map.remove(id) == null) {
			//DaoException cl=new DaoException(id, "Такого клиента не существует!");
			throw new DaoException(id, "There is no such client");

		}
		}


	public static Dao<Client> getInstance() {
		if(clientDao == null){
			clientDao=new ClientDaoImpl();
		}
		return clientDao;
	}

}