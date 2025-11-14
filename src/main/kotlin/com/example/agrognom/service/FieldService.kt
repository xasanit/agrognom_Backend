package com.example.agrognom.service

import com.example.agrognom.dto.FieldCreateDto
import com.example.agrognom.dto.FieldDto
import com.example.agrognom.entities.Field
import com.example.agrognom.entities.User
import com.example.agrognom.mapper.FieldMapper
import com.example.agrognom.repository.FieldRepository
import org.springframework.stereotype.Service

@Service
class FieldService (
    private val fieldRepository: FieldRepository,
    private val fieldMapper: FieldMapper,
    private val cropService: CropService,
    private val soilService: SoilService,
    private val regionService: RegionService,
) {

    fun findById(fieldId: Long): Field {
        return fieldRepository.findById(fieldId)
            .orElseThrow { RuntimeException("Field with id $fieldId not found") }
    }

    fun getFields(user: User): List<FieldDto> {
        return fieldRepository.findFieldsByUser(user)
            .map { fieldMapper.toDto(it) }
    }

    fun getField(id: Long, user: User): FieldDto {
        val field = fieldRepository.findById(id)
            .orElseThrow { RuntimeException("Field not found") }

        if (field.user?.id != user.id) {
            throw RuntimeException("Access denied") // нельзя взять чужое поле ❗
        }

        return fieldMapper.toDto(field)
    }

    fun createField(user: User, dto: FieldCreateDto): FieldDto {

        val field = fieldMapper.createdToEntity(dto)
        field.user = user
        field.crop = dto.cropId?.let { cropService.getCropById(it) }
        field.soil = dto.soilId?.let { soilService.getSoilById(it) }
        field.region = dto.regionId?.let { regionService.getRegionById(it) }
        val saved = fieldRepository.save(field)
        return fieldMapper.toDto(saved)

    }

    fun deleteFieldById(user: User, fieldId: Long) {
        val field = fieldRepository.findById(fieldId)
            .orElseThrow { RuntimeException("Field not found") }
        if (field.user?.id != user.id) throw RuntimeException("Access denied")
        fieldRepository.deleteById(fieldId)
    }
}