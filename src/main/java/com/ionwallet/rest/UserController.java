package com.ionwallet.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ionwallet.expensemgrutility.common.dtos.UsersDTO;
import com.ionwallet.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public UsersDTO saveUser(@RequestBody UsersDTO usersDTO){
		usersDTO.setDob(LocalDateTime.of(2000, 12, 12, 12, 12, 12));
		return userService.save(usersDTO);
	}

}
