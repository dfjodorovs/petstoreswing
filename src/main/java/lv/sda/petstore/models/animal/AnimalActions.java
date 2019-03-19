package lv.sda.petstore.models.animal;

import lv.sda.petstore.models.FoodTypes;

/*
* Eat checks if animal can eat a certain food.
*
*
* */
public interface AnimalActions {
    public boolean eat(FoodTypes foodType);
    public boolean makeSound();

}
