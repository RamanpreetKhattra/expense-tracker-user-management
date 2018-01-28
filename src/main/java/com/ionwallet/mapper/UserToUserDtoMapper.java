package com.ionwallet.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ionwallet.domain.Users;
import com.ionwallet.dto.UsersDTO;

@Component
public class UserToUserDtoMapper {
	@Autowired
	ModelMapper mapper;
	
	public UsersDTO covertToUsersDto(Users users){
		UsersDTO dto=mapper.map(users, UsersDTO.class);
		return dto;
	}
	
	public Users convertToUser(UsersDTO usersDTO){
		Users users=mapper.map(usersDTO,Users.class );
		return users;
	}
}
