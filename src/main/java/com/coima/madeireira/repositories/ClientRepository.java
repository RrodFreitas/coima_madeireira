package com.coima.madeireira.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coima.madeireira.entities.Cliente;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, String> {

	void deleteById(String cpf);

	Optional<Cliente> findById(String cpf);

}
