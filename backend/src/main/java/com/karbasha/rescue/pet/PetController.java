package com.karbasha.rescue.pet;

import com.karbasha.rescue.pet.dto.PetCreateDto;
import com.karbasha.rescue.pet.dto.PetUpdateDto;
import com.karbasha.rescue.util.Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pet")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('user')")
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
    public Pet create(@Dto(PetCreateDto.class) Pet pet) {
        return petService.create(pet);
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
