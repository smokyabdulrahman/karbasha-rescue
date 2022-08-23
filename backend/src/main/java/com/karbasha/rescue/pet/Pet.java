package com.karbasha.rescue.pet;

import com.karbasha.rescue.common.model.Audit;
import com.karbasha.rescue.user.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "pet")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet extends Audit {
    @Id
    UUID Id;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    UserProfile userProfile;
    @Column(updatable = false, insertable = false)
    UUID ownerId;
    String name;
    Integer age;
    Gender gender;
    String picture;
    String healthCondition;
    String vaccinated;
    Boolean neutered;
    String personalityDescription;
    String country;
    String city;
}