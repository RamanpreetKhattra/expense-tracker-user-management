package com.ionwallet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionwallet.domain.Roles;
import com.ionwallet.domain.Users;
import com.ionwallet.expensemgrutility.common.dtos.UsersDTO;
import com.ionwallet.mapper.UserToUserDtoMapper;
import com.ionwallet.repository.RoleRepository;
import com.ionwallet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserToUserDtoMapper mapper;
	
	@Override
	public UsersDTO save(UsersDTO usersDTO) {
		Users users=mapper.convertToEntity(usersDTO);
		List<Roles> roles=new ArrayList<Roles>();
		for(Roles role: users.getRoles()){
			role=roleRepository.findByRoleName(role.getRoleName());
			roles.add(role);
		}
		users.setRoles(roles);
		users=userRepository.save(users);
		usersDTO=mapper.covertToDto(users);
		return usersDTO;
		
	}

}
