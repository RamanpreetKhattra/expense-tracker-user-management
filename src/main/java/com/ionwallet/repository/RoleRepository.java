package com.ionwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ionwallet.domain.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer>{

	public Roles findByRoleName(String roleName);
}
