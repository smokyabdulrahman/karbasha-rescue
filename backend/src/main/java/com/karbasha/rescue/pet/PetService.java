package com.karbasha.rescue.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public Pet getPetById(UUID id) {
        return petRepository.getReferenceById(id);
    }
}
