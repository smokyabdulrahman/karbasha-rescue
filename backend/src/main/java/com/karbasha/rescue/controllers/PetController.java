package com.karbasha.rescue.controllers;

import com.karbasha.rescue.data.entities.pet.*;
import com.karbasha.rescue.dtos.pet.PetCreateDto;
import com.karbasha.rescue.dtos.pet.PetUpdateDto;
import com.karbasha.rescue.services.*;
import com.karbasha.rescue.util.Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pet")
@RequiredArgsConstructor
@PreAuthorize("hasRole('user')")
public class PetController {

    private final PetService petService;

    @GetMapping()
    public List<Pet> getAll() {
        return petService.getAll();
    }

    @GetMapping("/{id}")
    public Pet get(@PathVariable("id") UUID id) {
        return petService.getPetById(id);
    }

    @PostMapping
    public ResponseEntity<Pet> create(@RequestBody PetCreateDto pet) {
        return ResponseEntity.ok(petService.create(pet));
    }

    @PutMapping
    public Pet update(@Dto(PetUpdateDto.class) Pet pet) {
        return petService.update(pet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        petService.delete(id);
    }
}
