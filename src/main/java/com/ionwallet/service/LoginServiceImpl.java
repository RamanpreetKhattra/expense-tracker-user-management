package com.ionwallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionwallet.domain.Users;
import com.ionwallet.expensemgrutility.common.dtos.LoginDto;
import com.ionwallet.expensemgrutility.common.dtos.LoginResponseDTO;
import com.ionwallet.jwt.TokenUtils;
import com.ionwallet.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDTO login(LoginDto loginDto) {
		Users users = userRepository.findByEmail(loginDto.getUsername());
		if (users != null && users.getPassword().equals(loginDto.getPassword())) {
			return new LoginResponseDTO(TokenUtils.issueToken(users.getEmail(), TokenUtils.defaultIssuer, TokenUtils.defaultAudience));
		} else {
			return null;
		}
	}


}
