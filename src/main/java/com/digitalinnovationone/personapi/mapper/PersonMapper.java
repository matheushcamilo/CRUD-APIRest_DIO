package com.digitalinnovationone.personapi.mapper;

import com.digitalinnovationone.personapi.request.PersonDTO;
import com.digitalinnovationone.personapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //Método responsável por transformar PersonDTO em Person
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    //Método responsável por transformar Person em PersonDTO
    PersonDTO toDTO(Person person);
}
