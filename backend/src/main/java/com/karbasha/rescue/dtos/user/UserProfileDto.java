package com.karbasha.rescue.dtos.user;

import com.karbasha.rescue.dtos.pet.*;
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
