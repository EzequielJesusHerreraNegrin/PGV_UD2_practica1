package com.salesianoslacuesta.resources;

import java.util.Random;

public class Vegetable {
    private String farmer = "";
    private String vegetable = "";
    private final String[] VEGETAGLE_LIST = { "Lettuce", "Cabbage", "Onion", "Spinach", "Potato", "Celery", "Asparagus",
            "Radish", "Broccoli", "Artichoke", "Tomato", "Cucumber", "Eggplant", "Carrot", "Green bean" };
    private int growCooldown;

    public Vegetable(String farmer) {
        this.farmer = farmer;
        this.vegetable = getRandomVegetable();
        this.growCooldown = geCooldown();
    }

    public String getFarmer() {
        return farmer;
    }

    public void setFarmer(String farmer) {
        this.farmer = farmer;
    }

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public int getGrowCooldown() {
        return growCooldown;
    }

    public void setGrowCooldown(int growCooldown) {
        this.growCooldown = growCooldown;
    }

    private int geCooldown() {
        int cooldown = 1000 + (int) (Math.random() * ((4000 - 1000) + 1));
        return cooldown;
    }

    public String getRandomVegetable() {
        Random random = new Random();
        int index = random.nextInt(VEGETAGLE_LIST.length);
        return VEGETAGLE_LIST[index];

    }

    public String toString() {
        return "Vegetable [ Farmer =" + this.farmer + ", vegetable =" + this.vegetable + "]";
    }

}
