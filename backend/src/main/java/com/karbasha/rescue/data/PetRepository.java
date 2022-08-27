package com.karbasha.rescue.data;

import com.karbasha.rescue.data.entities.pet.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> {
}
