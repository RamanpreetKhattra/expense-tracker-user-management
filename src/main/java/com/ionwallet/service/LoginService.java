package com.ionwallet.service;

import com.ionwallet.expensemgrutility.common.dtos.LoginDto;
import com.ionwallet.expensemgrutility.common.dtos.LoginResponseDTO;

public interface LoginService {
	
	public LoginResponseDTO login(LoginDto loginDto);
	
}
