package com.tutorialdtbs;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PersonMapper {

    @Mapping(source = "fullName", target = "name")
    @Mapping(target = "email", ignore = true)
    User mapPersonToUser(Person person);
}
