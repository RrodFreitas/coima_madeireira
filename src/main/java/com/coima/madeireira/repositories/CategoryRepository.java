package com.coima.madeireira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coima.madeireira.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
