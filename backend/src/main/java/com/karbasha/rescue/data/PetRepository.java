package com.karbasha.rescue.data;

import com.karbasha.rescue.data.entities.pet.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {
    List<Pet> findAllByOwnerId(UUID ownerId);
}
