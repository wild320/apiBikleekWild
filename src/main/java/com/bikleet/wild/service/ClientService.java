package com.bikleet.wild.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikleet.wild.model.Client;
import com.bikleet.wild.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public Client create ( Client client) {
		return clientRepository.save(client);
		
	}
	
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	
	public void delete (Client client) {
		 clientRepository.delete(client);
	}
	
	public Optional<Client> findById (long id) {
		return clientRepository.findById(id);
	}
	

}
