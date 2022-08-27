package com.karbasha.rescue.services;

import com.karbasha.rescue.data.*;
import com.karbasha.rescue.data.entities.pet.*;
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

    public Pet create(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet update(Pet pet) {
        return petRepository.save(pet);
    }

    public void delete(UUID id) {
        petRepository.deleteById(id);
    }
}
