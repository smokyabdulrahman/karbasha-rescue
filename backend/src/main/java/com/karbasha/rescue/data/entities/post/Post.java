package com.karbasha.rescue.data.entities.post;

import com.karbasha.rescue.data.entities.pet.*;
import com.karbasha.rescue.data.entities.user.*;
import com.vladmihalcea.hibernate.type.basic.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.net.URL;
import java.util.*;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@TypeDef(name = "post_type", typeClass = PostgreSQLEnumType.class)
public class Post {
    @Id
    @Builder.Default
    UUID id = UUID.randomUUID();

    @Enumerated(EnumType.STRING)
    @Type(type = "post_type")
    @Column(nullable = false)
    PostType type;

    URL locationLink;

    @Length(max = 600)
    String description;

    @OneToOne
    @JoinColumn(name = "pet_id")
    Pet pet;

    @OneToOne
    @JoinColumn(name = "user_id")
    UserProfile user;

    @Length(max = 65)
    String title;

    URL imageUrl;
}
