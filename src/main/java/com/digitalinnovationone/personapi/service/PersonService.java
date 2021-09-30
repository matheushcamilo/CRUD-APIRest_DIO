package com.digitalinnovationone.personapi.service;

import com.digitalinnovationone.personapi.dto.MessageResponseDTO;
import com.digitalinnovationone.personapi.mapper.PersonMapper;
import com.digitalinnovationone.personapi.repository.PersonRepository;
import com.digitalinnovationone.personapi.request.PersonDTO;
import com.digitalinnovationone.personapi.entities.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
