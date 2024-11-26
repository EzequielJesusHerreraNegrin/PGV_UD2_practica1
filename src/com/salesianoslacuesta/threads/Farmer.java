package com.salesianoslacuesta.threads;

import com.salesianoslacuesta.resources.Crop;
import com.salesianoslacuesta.resources.Vegetable;

public class Farmer extends Thread {

    Crop crop;
    private Vegetable vegetable = new Vegetable(null);
    private String name = "";
    private int vegetableToSeed = 0;
    private int vegetableCounter;

    public Farmer(String name, int vegetableToSeed, Crop crop) {
        this.name = name;
        this.vegetableToSeed = vegetableToSeed;
        this.vegetableCounter = 0;
        this.crop = crop;

    }

    public void seed() {
        if (vegetableCounter <= vegetableToSeed) {
            vegetable = new Vegetable(name);
            this.crop.addNewVegetable(vegetable);
            vegetableCounter++;
        }
    }

    public int getVegetableToSeed() {
        return vegetableToSeed;
    }

    public void setVegetableToSeed(int vegetableToSeed) {
        this.vegetableToSeed = vegetableToSeed;
    }

    @Override
    public void run() {
        for (int i = 0; i < vegetableToSeed; i++) {
            try {
                Thread.sleep(vegetable.getGrowCooldown());
                seed();
                System.out.println(vegetable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}