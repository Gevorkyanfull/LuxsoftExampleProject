package com.guzichenko.services;

import java.util.List;

import com.guzichenko.dao.DaoException;
import com.guzichenko.domain.Client;
import com.guzichenko.exceptions.BusinessException;

public interface ClientService {

	/**
	 * add documentation
	 */

	Long createClient(ClientData data) throws BusinessException;

	void modifyClient(Long id, ClientData data);
	void removeClient(Long id) throws DaoException;

	List<Client> getAllClients();

	void deleteClient();


}