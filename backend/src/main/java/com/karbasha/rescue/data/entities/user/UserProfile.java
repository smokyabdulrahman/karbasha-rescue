package com.karbasha.rescue.data.entities.user;

import com.karbasha.rescue.common.model.Audit;
import lombok.*;

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
@Getter
@Setter
public class UserProfile extends Audit {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();
    @Column(unique = true)
    private String username;
    @NotEmpty
    private String name;
    private int age;
    @Email
    @NotEmpty
    private String email;
    private String phone;
    private String neighborhood;
    private String city;
    private boolean hasKids;
    private BigDecimal monthlyIncome;
}


