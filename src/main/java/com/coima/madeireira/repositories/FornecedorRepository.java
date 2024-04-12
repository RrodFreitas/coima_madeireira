package com.coima.madeireira.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coima.madeireira.entities.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {

	void deleteById(String cnpj);

	Optional<Fornecedor> findById(String cnpj);

}
