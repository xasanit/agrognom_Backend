package com.example.agrognom.adapter

import com.example.agrognom.entities.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
    private val user: User
) : UserDetails {

    override fun getUsername() = user.username!!
    override fun getPassword() = user.password!!
    override fun getAuthorities(): Collection<GrantedAuthority?>? = mutableListOf<GrantedAuthority>()

    fun getUser() = user

}