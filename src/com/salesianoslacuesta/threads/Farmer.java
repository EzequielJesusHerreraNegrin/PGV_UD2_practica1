package com.salesianoslacuesta.threads;

import com.salesianoslacuesta.resources.Crop;
import com.salesianoslacuesta.resources.Vegetable;

public class Farmer extends Thread {

    private Crop crop;
    private String name;
    private int vegetableToSeed;

    public Farmer(String name, int vegetableToSeed, Crop crop) {
        this.name = name;
        this.vegetableToSeed = vegetableToSeed;
        this.crop = crop;

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
                synchronized (crop) {
                    Vegetable vegetable = new Vegetable(name);
                    Thread.sleep(2000);
                    this.crop.addNewVegetable(vegetable);
                    System.out.println(this.name + " ha plantado el vegetal " + vegetable.getVegetable());
                    crop.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "plantÃ³ todos sus vegetales");
    }
}