package lv.sda.petstore.models.animal;

import lv.sda.petstore.models.FoodTypes;
import lv.sda.petstore.models.Size;

public class Cat extends Animal {

    public Cat(Size s) {
        super(s);
    }

    @Override
    public boolean eat(FoodTypes foodType) {
        return false;
    }

    @Override
    public boolean makeSound() {
        return false;
    }
}