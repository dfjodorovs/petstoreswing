package lv.sda.petstore.models.cage;

import lv.sda.petstore.models.Size;
import lv.sda.petstore.models.animal.Animal;

import java.time.LocalDateTime;

public class Cage {
    private Size size;
    private Animal animal;
    private CageInfo cageInfo;

    public Cage(Size size, CageInfo cageInfo) {
        this.size = size;
        this.cageInfo = cageInfo;
    }

    public Size getSize() {
        return size;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {

        if(animal == null){
            this.animal = null;
            this.getCageInfo().setAnimalPlacedDate(null);
            return;
        }

        if(this.size.getValue() >= animal.getSize().getValue()){
            this.animal = animal;
            this.getCageInfo().setAnimalPlacedDate(LocalDateTime.now());
            return;
        }
    }

    public CageInfo getCageInfo() {
        return cageInfo;
    }

    public void setCageInfo(CageInfo cageInfo) {
        this.cageInfo = cageInfo;
    }

    public boolean isFree(){
        return animal == null ? true : false;
    }
}
