package lv.sda.petstore.models.animal;

import lv.sda.petstore.models.FoodTypes;
import lv.sda.petstore.models.HealthLevel;
import lv.sda.petstore.models.Size;

import java.util.ArrayList;
import java.util.List;

/*
Has name
Age
size
health level
Allowed food types

 */
public abstract class Animal implements AnimalActions {
    private int age;
    private Size size;
    private String name;
    private HealthLevel healthLevel;
    private List<FoodTypes> allowedFoodTypes;

    public Animal(Size s) {
        this.size = s;
        allowedFoodTypes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public HealthLevel getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(HealthLevel healthLevel) {
        this.healthLevel = healthLevel;
    }

    public List<FoodTypes> getAllowedFoodTypes() {
        return allowedFoodTypes;
    }

    public void setAllowedFoodTypes(List<FoodTypes> allowedFoodTypes) {
        this.allowedFoodTypes = allowedFoodTypes;
    }
}
