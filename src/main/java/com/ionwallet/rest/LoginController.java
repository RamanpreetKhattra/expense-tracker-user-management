package com.ionwallet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ionwallet.expensemgrutility.common.dtos.LoginDto;
import com.ionwallet.expensemgrutility.common.dtos.LoginResponseDTO;
import com.ionwallet.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired LoginService loginService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public LoginResponseDTO loginAuthentication(@RequestBody LoginDto loginDto){
		return loginService.login(loginDto);
		
	}
	
}
