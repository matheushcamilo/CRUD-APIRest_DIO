package com.digitalinnovationone.personapi.controller;

import com.digitalinnovationone.personapi.tables.Person;
import com.digitalinnovationone.personapi.tables.Phone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    //HTTP GET receberá o que for definido abaixo
    @GetMapping
    public String getBook(){
        Phone phone = new Phone();
        phone.setNumber("99999-9999");
        return "API Test!\n" + phone.getNumber();
    }
}
