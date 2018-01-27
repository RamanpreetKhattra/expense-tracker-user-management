package com.ionwallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionwallet.domain.Users;
import com.ionwallet.dto.UsersDTO;
import com.ionwallet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void save(UsersDTO usersDTO) {
		Users users=new Users();
		users.setFirstName(usersDTO.getFirstName());
		userRepository.save(users);
		
	}

}
