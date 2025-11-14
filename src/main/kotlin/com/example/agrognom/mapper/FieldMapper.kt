package com.example.agrognom.mapper

import com.example.agrognom.dto.FieldCreateDto
import com.example.agrognom.dto.FieldDto
import com.example.agrognom.entities.Field
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface FieldMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "crop.id", target = "cropId")
    @Mapping(source = "soil.id", target = "soilId")
    @Mapping(source = "region.id", target = "regionId")
    fun toDto(field: Field): FieldDto

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "crop", ignore = true)
    @Mapping(target = "soil", ignore = true)
    @Mapping(target = "region", ignore = true)
    fun createdToEntity(dto: FieldCreateDto): Field
}
