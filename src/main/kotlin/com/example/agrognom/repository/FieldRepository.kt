package com.example.agrognom.repository

import com.example.agrognom.entities.Field
import com.example.agrognom.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FieldRepository: JpaRepository<Field, Long> {

    fun findFieldsByUser(user: User): List<Field>

}