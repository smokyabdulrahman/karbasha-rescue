package com.karbasha.rescue.user.dto;

import com.karbasha.rescue.pet.dto.*;
import lombok.*;

import java.math.*;
import java.util.*;

@Value
@Builder
public class UserProfileDto {
    UUID id;
    String username;
    String name;
    int age;
    String email;
    String phone;
    String neighborhood;
    String city;
    boolean hasKids;
    BigDecimal monthlyIncome;
    List<PetDto> pets;
}
