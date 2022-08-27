package com.karbasha.rescue.data.entities.pet;

import com.karbasha.rescue.common.model.Audit;
import com.karbasha.rescue.data.entities.*;
import com.vladmihalcea.hibernate.type.basic.*;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "pet")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@TypeDef(name = "gender_type", typeClass = PostgreSQLEnumType.class)
public class Pet extends Audit {
    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();
    @Column(nullable = false)
    private UUID ownerId;
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    @Type(type = "gender_type")
    @Column(nullable = false)
    private Gender gender;
    private String picture;
    private String healthCondition;
    private Boolean vaccinated;
    private Boolean neutered;
    private String personalityDescription;
    private String country;
    private String city;
}