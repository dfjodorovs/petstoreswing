package lv.sda.petstore.controllers;

import lv.sda.petstore.models.AnimalDao;
import lv.sda.petstore.models.Size;
import lv.sda.petstore.models.animal.Animal;
import lv.sda.petstore.models.Caretaker;
import lv.sda.petstore.models.animal.AnimalType;
import lv.sda.petstore.models.animal.Cat;
import lv.sda.petstore.models.animal.Parrot;
import lv.sda.petstore.models.cage.Cage;
import lv.sda.petstore.models.cage.CageInfo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Hold cages
has a caretaker
stores food for all kind of animal
care taker can feed animal only if there is enough food.
 */
public class StoreManagement implements Management {

    private List<Cage> catCages;
    private List<Cage> parrotCages;
    private Caretaker caretaker;

    public StoreManagement() {
        catCages = new ArrayList<>();
        parrotCages = new ArrayList<>();
    }

    @Override
    public void createCaretaker(String name) {
        caretaker = new Caretaker(name);
    }

    @Override
    public void changeCaretaker(String name) {
        caretaker.setName(name);
    }

    @Override
    public void createAnimal(AnimalType animalType) {
        switch (animalType) {
            case CAT:
                createCat();
                break;
            case DOG:
                createDog();
                break;
            case PARROT:
                createParrot();
                break;
        }
    }

    @Override
    public void createParrot() {
        Size size = Size.SMALL;
        Parrot parrot = new Parrot(size);
        placeAnimalInCage(parrot, size, parrotCages);
    }

    @Override
    public void createCat() {
        Size size = Size.MEDIUM;
        Cat cat = new Cat(size);
        placeAnimalInCage(cat, size, catCages);
    }

    @Override
    public void createDog() {
        Size size = Size.MEDIUM;
        Cat cat = new Cat(size);
        placeAnimalInCage(cat, size, catCages);
    }

    @Override
    public List<AnimalDao> getAnimalList() {
        List<AnimalDao> collect = Stream.concat(
                catCages.stream(),
                parrotCages.stream())
                .map(i->
                {
                    AnimalDao animalDao = new AnimalDao();
                    animalDao.setName(i.getAnimal().getName());
                    animalDao.setImage(i.getCageInfo().getImage());
                    animalDao.setHealthLevel(i.getAnimal().getHealthLevel());
                    return animalDao;
                }).collect(Collectors.toList());
        return collect;
    }

    private void placeAnimalInCage(Animal animal, Size s, List<Cage> list) {
        CageInfo cageInfo = new CageInfo(
                LocalDateTime.now());
        Cage cage = new Cage(s, cageInfo);
        cage.setAnimal(animal);
        list.add(cage);
    }

}
