package lv.sda.petstore.models;

import java.io.File;

public class AnimalDao {

    private String name;
    private File image;
    private HealthLevel healthLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public HealthLevel getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(HealthLevel healthLevel) {
        this.healthLevel = healthLevel;
    }
}
