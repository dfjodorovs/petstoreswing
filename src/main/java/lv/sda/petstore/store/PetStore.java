package lv.sda.petstore.store;

import lv.sda.petstore.controllers.Management;
import lv.sda.petstore.controllers.StoreManagement;
import lv.sda.petstore.ui.PetStoreUI;
import lv.sda.petstore.ui.UIGenerator;

/*
Holds ui generator
Holds store management
 */
public class PetStore {

    private UIGenerator uiGenerator;
    private Management management;

    public PetStore() {
        management = new StoreManagement();
        uiGenerator = new PetStoreUI(management);
        uiGenerator.generate();
    }
}
