package com.coima.madeireira.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coima.madeireira.entities.Product;
import com.coima.madeireira.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{

	@Query("SELECT DISTINCT obj FROM Venda obj INNER JOIN obj.products prod WHERE "
			+ "(COALESCE(:produtos) IS NULL OR prod IN :produtos)")
	Page<Venda> find(List<Product> produtos, Pageable pageable);
	
	@Query("SELECT obj FROM Venda obj JOIN FETCH obj.products WHERE obj IN :vendas")
	List<Venda> buscarVendasComProdutos(List<Venda> vendas);
}
