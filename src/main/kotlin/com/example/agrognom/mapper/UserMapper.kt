package com.example.agrognom.mapper

import com.example.agrognom.dto.FieldDto
import com.example.agrognom.dto.UserDto
import com.example.agrognom.entities.User
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun toDto(user: User): UserDto
}