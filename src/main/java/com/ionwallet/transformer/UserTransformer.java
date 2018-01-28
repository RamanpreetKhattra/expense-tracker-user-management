package com.ionwallet.transformer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ionwallet.domain.Roles;
import com.ionwallet.domain.Users;
import com.ionwallet.expensemgrutility.common.dtos.RoleDto;
import com.ionwallet.expensemgrutility.common.dtos.UsersDTO;
import com.ionwallet.mapper.RoleToRoleDtoMapper;
import com.ionwallet.mapper.UserToUserDtoMapper;

@Component
public class UserTransformer {
	@Autowired
	UserToUserDtoMapper mapper;
	
	@Autowired
	RoleToRoleDtoMapper roleDtoMapper;
	
	public UsersDTO convertUserToDTO(Users users){
		UsersDTO usersDTO=mapper.covertToDto(users);
		List<RoleDto> roleDto=roleDtoMapper.covertToDtoList(users.getRoles());
		usersDTO.setRoles(roleDto);
		return usersDTO;
	}
	
	public Users convertDtoToUsers(UsersDTO dto){
		Users users=mapper.convertToEntity(dto);
//		List<Roles> roles=roleDtoMapper.convertToEntityList(dto.getRoles());
//		users.setRoles(roles);
		return users;
	}
	
}
