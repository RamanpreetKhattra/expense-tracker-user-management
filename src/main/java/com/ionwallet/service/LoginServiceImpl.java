package com.ionwallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionwallet.domain.Users;
import com.ionwallet.expensemgrutility.common.dtos.LoginDto;
import com.ionwallet.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Boolean login(LoginDto loginDto) {
		Users users = userRepository.findByEmail(loginDto.getUsername());
		if (users != null && users.getPassword().equals(loginDto.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean isAuthorized(String username) {
		Users users = userRepository.findByEmail(username);
		if (users != null) {
			return true;
		} else {
			return false;
		}
	}

}
