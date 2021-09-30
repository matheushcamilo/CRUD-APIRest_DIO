package com.digitalinnovationone.personapi.controller;

import com.digitalinnovationone.personapi.dto.MessageResponseDTO;
import com.digitalinnovationone.personapi.repository.PersonRepository;
import com.digitalinnovationone.personapi.service.PersonService;
import com.digitalinnovationone.personapi.tables.Person;
import com.digitalinnovationone.personapi.tables.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//Indicando que todos os métodos dessa classe retornam um domain object
//Um atalho para incluir @Controller e @ResponseBody
@RestController
//A linha abaixo é desnecessária;
@RequestMapping("/api/v1/people")
public class PersonController {

    //as regras de negócio vêm do pacote service
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    //HTTP GET
    //HTTP POST
    @PostMapping
    //Para retornar o código 201, quando criar uma pessoa. Por definição, era 200.
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
