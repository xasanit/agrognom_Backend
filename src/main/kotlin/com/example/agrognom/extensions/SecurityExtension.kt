package com.example.agrognom.extensions

import com.example.agrognom.adapter.CustomUserDetails
import com.example.agrognom.entities.User

fun CustomUserDetails.user(): User = this.getUser()