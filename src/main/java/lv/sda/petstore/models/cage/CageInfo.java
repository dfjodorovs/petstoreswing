package lv.sda.petstore.models.cage;

import java.io.File;
import java.time.LocalDateTime;

public class CageInfo {
    private File image;
    private LocalDateTime animalPlacedDate;

    public CageInfo(LocalDateTime animalPlacedDate) {
        this.animalPlacedDate = animalPlacedDate;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public LocalDateTime getAnimalPlacedDate() {
        return animalPlacedDate;
    }

    public void setAnimalPlacedDate(LocalDateTime animalPlacedDate) {
        this.animalPlacedDate = animalPlacedDate;
    }
}
