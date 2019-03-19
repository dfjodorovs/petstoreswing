package lv.sda.petstore.models;

public enum Size {
    SMALL(0),MEDIUM(1),LARGE(2);

    int value = -1;

    Size(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
