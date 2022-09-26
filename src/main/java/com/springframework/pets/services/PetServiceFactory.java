package com.springframework.pets.services;



public class PetServiceFactory {

    public PetService getPetService(String type){
        if(type=="cat"){
            return new CatPetService();
        }else if(type=="dog"){
            return new DogPetService();
        }else{
            return new DogPetService();
        }
    }
}
