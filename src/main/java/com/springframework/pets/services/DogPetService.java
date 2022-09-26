package com.springframework.pets.services;



public class DogPetService implements PetService{

    @Override
    public String getPetType() {
        return "Dogs Are the Best!";
    }
}
