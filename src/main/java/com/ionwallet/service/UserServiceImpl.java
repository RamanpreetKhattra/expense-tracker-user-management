package com.ionwallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionwallet.domain.Users;
import com.ionwallet.expensemgrutility.common.dtos.UsersDTO;
import com.ionwallet.mapper.UserToUserDtoMapper;
import com.ionwallet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserToUserDtoMapper mapper;
	
	@Override
	public UsersDTO save(UsersDTO usersDTO) {
		Users users=mapper.convertToEntity(usersDTO);
		//find role by rolename
		users=userRepository.save(users);
		usersDTO=mapper.covertToDto(users);
		return usersDTO;
		
	}

}
