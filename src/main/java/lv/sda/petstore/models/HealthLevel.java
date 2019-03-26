package lv.sda.petstore.models;

/*
Has food level
Care level
Health level
 */
public class HealthLevel {

    public final static int DECREASE_FOOD_LEVEL = 80;
    public static final int DECREASE_CARE_LEVEL = 30;

    private final int foodIncreaseStep = 10;
    private final int careIncreaseStep = 10;

    private final int bottomValue = 0;
    private final int topValue = 100;

    private int foodLevel = 1;
    private int careLevel = 1;
    private int health = 10;

    public int getFoodLevel() {
        return foodLevel;
    }

    public int getCareLevel() {
        return careLevel;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth() {
        health--;
        if (health <= bottomValue) {
            health = bottomValue;
        }
    }

    public void increaseHealth() {
        health++;
        if (health >= topValue) {
            health = topValue;
        }
    }

    public void decreaseFoodLevel() {
        foodLevel--;
        if (foodLevel <= bottomValue) {
            foodLevel = bottomValue;
        }
    }

    public void decreaseCareLevel() {
        careLevel--;
        if (careLevel <= bottomValue) {
            careLevel = bottomValue;
        }
    }

    public void increaseFoodLevel() {
        foodLevel += foodIncreaseStep;
        if (foodLevel >= topValue) {
            foodLevel = topValue;
        }
    }

    public void increaseCareLevel() {
        careLevel += careIncreaseStep;
        if (careLevel >= topValue) {
            careLevel = topValue;
        }
    }
}
