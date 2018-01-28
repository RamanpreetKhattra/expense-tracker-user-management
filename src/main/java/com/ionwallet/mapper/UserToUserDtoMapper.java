package com.ionwallet.mapper;

import org.springframework.stereotype.Component;

import com.ionwallet.domain.Users;
import com.ionwallet.dto.UsersDTO;
import com.ionwallet.mapper.base.AbstractMapper;

@Component
public class UserToUserDtoMapper extends AbstractMapper<UsersDTO, Users> {
}
