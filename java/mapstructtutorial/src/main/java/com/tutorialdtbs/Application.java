package com.tutorialdtbs;

import org.mapstruct.factory.Mappers;

public class Application {

    public static void main(String[] args) {

        PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);

        Person person = new Person();
        person.setAge(12);
        person.setFullName("Test Name");
        person.setEmail("testemail@tutorialdtbs.com");

        User user = personMapper.mapPersonToUser(person);
    }
}
