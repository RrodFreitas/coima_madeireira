package com.coima.madeireira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coima.madeireira.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
