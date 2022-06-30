package com.bikleet.wild.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikleet.wild.model.Client;
import com.bikleet.wild.service.ClientService;

@RestController
@RequestMapping ("/api/client/")
public class ClientRest {
	@Autowired
	private ClientService clientService;
	
	@PostMapping
	private ResponseEntity<Client> save (@RequestBody Client client){
		Client aux = clientService.create(client);
		try {
			return ResponseEntity.created(new URI("api/client/"+aux.getId())).body(aux);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping
	private ResponseEntity<List<Client>> listAllClient (){
		return  ResponseEntity.ok(clientService.getAllClients());		
	}
	
	@DeleteMapping
	private ResponseEntity<Void> deleteClient (@RequestBody Client client){
		clientService.delete(client);
		return  ResponseEntity.ok().build();		
	}
	
	@GetMapping (value = "get/{id}")
	private ResponseEntity<Optional<Client>> findClient (@PathVariable ("id")Long id){
		return  ResponseEntity.ok(clientService.findById(id));		
	}

}
