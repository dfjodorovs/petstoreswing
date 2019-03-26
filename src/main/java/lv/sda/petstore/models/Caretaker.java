package lv.sda.petstore.models;

// can feed animal has  a name
// can pet animal(care for it)

import lv.sda.petstore.models.animal.Animal;

public class Caretaker {

    private String name;

    public Caretaker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed(Animal a) {
        a.getHealthLevel().increaseFoodLevel();
    }

    public void care(Animal a) {
        a.getHealthLevel().increaseCareLevel();
    }
}
