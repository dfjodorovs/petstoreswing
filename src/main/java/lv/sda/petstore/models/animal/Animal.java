package lv.sda.petstore.models.animal;

import lv.sda.petstore.models.FoodTypes;
import lv.sda.petstore.models.HealthLevel;
import lv.sda.petstore.models.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.Thread.sleep;

/*
Has name
Age
size
health level
Allowed food types

 */
public abstract class Animal implements AnimalActions {
    private String id;
    private int age;
    private Size size;
    private String name;
    private HealthLevel healthLevel;
    private List<FoodTypes> allowedFoodTypes;

    public Animal(Size s) {
        id = UUID.randomUUID().toString();
        this.size = s;
        allowedFoodTypes = new ArrayList<>();
        healthLevel = new HealthLevel();
        bringToLife();
    }

    public String getId() {
        return id;
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

    private void bringToLife(){
        Thread t = new Thread(
                ()->{
                    while (true){
                        try {
                            sleep(500);
                            if(healthLevel.getFoodLevel() < HealthLevel.DECREASE_FOOD_LEVEL
                                || healthLevel.getCareLevel() < HealthLevel.DECREASE_CARE_LEVEL){
                                healthLevel.decreaseHealth();
                            }

                            if(healthLevel.getFoodLevel() > HealthLevel.DECREASE_FOOD_LEVEL
                                    && healthLevel.getCareLevel() > HealthLevel.DECREASE_CARE_LEVEL){
                                healthLevel.increaseHealth();
                            }

                            healthLevel.decreaseFoodLevel();
                            healthLevel.decreaseCareLevel();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        t.start();
    }
}
