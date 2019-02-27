package com.guzichenko.services.impl;

import com.guzichenko.dao.Dao;
import com.guzichenko.dao.DaoException;
import com.guzichenko.domain.Client;
import com.guzichenko.exceptions.BusinessException;
import com.guzichenko.services.ClientData;
import com.guzichenko.services.ClientService;
import com.guzichenko.validators.ValidationService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

	private Dao<Client> clientDao;
	private ValidationService validationService;

	public ClientServiceImpl(Dao<Client> clientDao, ValidationService validationService) {
		this.clientDao = clientDao;
		this.validationService = validationService;
	}

	@Override
	public Long createClient(ClientData data) throws BusinessException {

			validationService.validateAge(data.age);
			validationService.validateEmail(data.email);
			validationService.validatePhone(data.phoneNumber);
			Client client = new Client(data.name, data.surname, data.age, data.email, data.phoneNumber);
			return clientDao.save(client);


	}

    @Override
    public void modifyClient(Long id, ClientData data) {
        // get client by id;
        Client client = clientDao.get(id);

        // modify client data;
        client.setName(data.name);
        client.setSurname(data.surname);
        client.setAge(data.age);
        client.setPhone(data.phoneNumber);
        client.setEmail(data.email);

        // save client back to storage;
        clientDao.save(client);
    }

	@Override
	public void removeClient(Long id) throws DaoException {
		clientDao.remove(id);
	}

	@Override
	public List<Client> getAllClients() {
		return clientDao.getAll();
	}

	@Override
	public void deleteClient() {

	}
}
