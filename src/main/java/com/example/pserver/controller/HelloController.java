package com.example.pserver.controller;

import com.example.pserver.entity.AddressEntity;
import com.example.pserver.entity.PersonEntity;
import com.example.pserver.entity.ZipEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping(value = "/getPerson")
    private PersonEntity getPerson(@RequestHeader("key") String key, @RequestParam("name") String name) {
        System.out.println("header key is " + key);
        PersonEntity person1 = new PersonEntity();
        person1.setName(name);
        person1.setAge(20);
        person1.setGender("male");
        AddressEntity address1 = new AddressEntity();
        address1.setStreet("123 Main Street");
        ZipEntity zip1 = new ZipEntity();
        zip1.setZip("12345");
        address1.setZip(zip1);
        person1.setAddress(address1);
        return person1;
    }

    @PostMapping(value = "/person")
    public PersonEntity createPerson(@RequestBody PersonEntity params){
        PersonEntity person1 = new PersonEntity();
        person1.setName(params.getName());
        person1.setGender(params.getGender());
        person1.setAge(params.getAge());

        return person1;
    }
}
