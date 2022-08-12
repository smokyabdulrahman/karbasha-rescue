package com.karbasha.rescue.user;

import com.karbasha.rescue.common.model.Audit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "user_profile")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile extends Audit {
    @Id
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
