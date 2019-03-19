package lv.sda.petstore.controllers;

import lv.sda.petstore.models.AnimalDao;
import lv.sda.petstore.models.animal.Animal;
import lv.sda.petstore.models.animal.AnimalType;

import java.util.List;

/*
Holds cages with animal
Has a caretaker
Has food for animal
 */
public interface Management {
    void createCaretaker(String text);
    void changeCaretaker(String text);
    void createAnimal(AnimalType animalType);
    void createParrot();
    void createCat();
    void createDog();

    List<AnimalDao> getAnimalList();

}
