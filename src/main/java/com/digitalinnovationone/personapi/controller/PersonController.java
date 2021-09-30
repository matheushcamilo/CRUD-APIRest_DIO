package com.digitalinnovationone.personapi.controller;

import com.digitalinnovationone.personapi.dto.MessageResponseDTO;
import com.digitalinnovationone.personapi.entities.Person;
import com.digitalinnovationone.personapi.request.PersonDTO;
import com.digitalinnovationone.personapi.service.PersonNotFoundException;
import com.digitalinnovationone.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    //Retorna 200 por padrão
    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
}
