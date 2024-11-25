package com.salesianoslacuesta.resources;

public class Vegetable {
    private String farmer = "";
    private String vegetable = "";
    private final String[] VEGETAGLE_LIST = { "Lettuce", "Cabbage", "Onion", "Spinach", "Potato", "Celery", "Asparagus",
            "Radish", "Broccoli", "Artichoke", "Tomato", "Cucumber", "Eggplant", "Carrot", "Green bean" };
    private int growCooldown;

    public Vegetable(String farmer, int vegetable) {
        this.farmer = farmer;
        this.vegetable = VEGETAGLE_LIST[vegetable];
        this.growCooldown = getVegetableCooldown();
    }

    private int getVegetableCooldown() {
        int cooldown = (int) (Math.random() * (3000 - 1000)) * 1000;
        return cooldown;
    }
}
