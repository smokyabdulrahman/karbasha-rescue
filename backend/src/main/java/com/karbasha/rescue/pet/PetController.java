package com.karbasha.rescue.pet;

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

    private List<Pet> getAll()
    {
        return petService.getAll();
    }

    @GetMapping("/{id}")
    private Pet get(@PathVariable("id") UUID id)
    {
        return petService.getPetById(id);
    }

//    @PostMapping
//    private int create(@RequestBody Pet pet)
//    {
//        return petService.saveOrUpdate(pet);
//    }
//
//    @PutMapping
//    private Pets update(@RequestBody Pets pets)
//    {
//        petService.saveOrUpdate(pets);
//        return pets;
//    }
//
//    @DeleteMapping("/{id}")
//    private void delete(@PathVariable("id") UUID id)
//    {
//        petService.delete(id);
//    }
}
