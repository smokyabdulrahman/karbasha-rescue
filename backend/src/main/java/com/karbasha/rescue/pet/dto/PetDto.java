package com.karbasha.rescue.pet.dto;

import com.karbasha.rescue.pet.*;
import lombok.*;

import java.util.*;

@Value
@Builder
public class PetDto {
    UUID id;
    String name;
    Integer age;
    Gender gender;
    String picture;
    String healthCondition;
    Boolean vaccinated;
    Boolean neutered;
    String personalityDescription;
    String country;
    String city;
}
