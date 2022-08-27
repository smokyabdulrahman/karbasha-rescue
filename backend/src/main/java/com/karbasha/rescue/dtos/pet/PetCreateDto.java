package com.karbasha.rescue.dtos.pet;

import com.karbasha.rescue.data.entities.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class PetCreateDto {
    @NotNull
    String name;
    @NotNull
    UUID ownerId;
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
