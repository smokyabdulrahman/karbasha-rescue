package com.karbasha.rescue.user;

import com.karbasha.rescue.common.model.Audit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "user_profile")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile extends Audit {

    @Id
    UUID id;
    @Column(unique = true)
    String username;
    @NotEmpty
    String name;
    int age;
    @Email
    @NotEmpty
    String email;
    String phone;
    String neighborhood;
    String city;
    boolean hasKids;
    BigDecimal monthlyIncome;
}


