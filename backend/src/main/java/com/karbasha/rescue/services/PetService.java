package com.karbasha.rescue.services;

import com.karbasha.rescue.data.*;
import com.karbasha.rescue.data.entities.pet.*;
import com.karbasha.rescue.dtos.pet.*;
import com.karbasha.rescue.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public Pet getPetById(UUID id) {
        return petRepository.getReferenceById(id);
    }

    public Pet create(PetCreateDto petCreateDto) {
        var owner = userRepository.findById(petCreateDto.getOwnerId());
        if (owner.isEmpty()) {
            throw new RecordNotFoundException("Owner not found with id: " + petCreateDto.getOwnerId());
        }

        var pet = Pet.builder()
                .age(petCreateDto.getAge())
                .city(petCreateDto.getCity())
                .country(petCreateDto.getCountry())
                .gender(petCreateDto.getGender())
                .healthCondition(petCreateDto.getHealthCondition())
                .name(petCreateDto.getName())
                .neutered(petCreateDto.getNeutered())
                .picture(petCreateDto.getPicture())
                .personalityDescription(petCreateDto.getPersonalityDescription())
                .vaccinated(petCreateDto.getVaccinated())
                .ownerId(owner.get().getId())
                .build();

        return petRepository.save(pet);
    }

    public Pet update(Pet pet) {
        return petRepository.save(pet);
    }

    public void delete(UUID id) {
        petRepository.deleteById(id);
    }

}
