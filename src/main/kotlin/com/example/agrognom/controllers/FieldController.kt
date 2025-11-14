package com.example.agrognom.controllers

import com.example.agrognom.adapter.CustomUserDetails
import com.example.agrognom.dto.FieldCreateDto
import com.example.agrognom.dto.FieldDto
import com.example.agrognom.extensions.user
import com.example.agrognom.service.FieldService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/fields")
class FieldController(
    private val fieldService: FieldService
) {
    
    @GetMapping
    fun getFields(
        @AuthenticationPrincipal userDetails: CustomUserDetails
    ): List<FieldDto> {
        return fieldService.getFields(userDetails.user())
    }

    @GetMapping("/{id}")
    fun getField(
        @AuthenticationPrincipal userDetails: CustomUserDetails,
        @PathVariable id: Long
    ): FieldDto {
        return fieldService.getField(id, userDetails.user())
    }

    @PostMapping("/create")
    fun createField(
        @AuthenticationPrincipal userDetails: CustomUserDetails,
        @RequestBody creteDto: FieldCreateDto
    ): FieldDto {
        return fieldService.createField(userDetails.user(), creteDto)
    }

    @DeleteMapping("/{id}")
    fun deleteField(
        @AuthenticationPrincipal userDetails: CustomUserDetails,
        @PathVariable id: Long) {
        fieldService.deleteFieldById(userDetails.user(), id)
    }
}