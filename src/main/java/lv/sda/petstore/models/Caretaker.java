package lv.sda.petstore.models;

// can feed animal has  a name
// can pet animal(care for it)

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
}
