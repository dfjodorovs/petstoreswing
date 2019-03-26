package lv.sda.petstore.models;

import org.junit.Assert;

public class HealthLevelTest {

    @org.junit.Test
    public void decreaseFoodLevelTest() {
        HealthLevel healthLevel = new HealthLevel();
        healthLevel.decreaseFoodLevel();
        Assert.assertEquals(99,healthLevel.getFoodLevel());
    }

    @org.junit.Test
    public void decreaseCareLevel() {
        HealthLevel healthLevel = new HealthLevel();
        healthLevel.decreaseCareLevel();
        Assert.assertEquals(99,healthLevel.getCareLevel());

    }

    @org.junit.Test
    public void increaseFoodLevel() {
        HealthLevel healthLevel = new HealthLevel();
        healthLevel.increaseFoodLevel();
        Assert.assertEquals(100,healthLevel.getFoodLevel());

    }

    @org.junit.Test
    public void increaseCareLevel() {
        HealthLevel healthLevel = new HealthLevel();
        healthLevel.increaseCareLevel();
        Assert.assertEquals(100,healthLevel.getCareLevel());
    }
}