package lv.sda.petstore.models.animal;

import lv.sda.petstore.models.FoodTypes;
import lv.sda.petstore.models.Size;

/*
Type
Size
 */
public class Parrot extends Animal {

    public Parrot(Size s) {
        super(s);
    }

    // Increase health level
    public boolean eat(FoodTypes foodType) {
        if(getAllowedFoodTypes().contains(foodType)){
            return true;
        }
        return false;
    }

    public boolean makeSound() {
        return false;
    }
}
