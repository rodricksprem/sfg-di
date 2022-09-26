package com.springframework.pets.services;


public class CatPetService implements PetService {

    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}
