package com.example.agrognom.service

import com.example.agrognom.dto.UserDto
import com.example.agrognom.entities.User
import com.example.agrognom.mapper.UserMapper
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userMapper: UserMapper
) {

    fun getUserDto(user: User) :  UserDto {
        return userMapper.toDto(user)
    }
}