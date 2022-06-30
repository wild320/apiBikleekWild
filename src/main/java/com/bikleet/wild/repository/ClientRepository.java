package com.bikleet.wild.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikleet.wild.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
