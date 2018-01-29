package com.ionwallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionwallet.domain.Roles;
import com.ionwallet.expensemgrutility.common.dtos.RoleDto;
import com.ionwallet.mapper.RoleToRoleDtoMapper;
import com.ionwallet.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleToRoleDtoMapper mapper;
	@Autowired
	RoleRepository roleRepo;
	
	@Override
	public RoleDto save(RoleDto roleDto) {
		Roles roles=mapper.convertToEntity(roleDto);
		roles=roleRepo.save(roles);
		roleDto=mapper.covertToDto(roles);
		return roleDto;
	}

}
