package com.ionwallet.service;

import com.ionwallet.expensemgrutility.common.dtos.LoginDto;

public interface LoginService {
	public Boolean login(LoginDto loginDto);
	
	public Boolean isAuthorized(String username);
}
