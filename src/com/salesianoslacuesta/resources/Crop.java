package com.salesianoslacuesta.resources;

import java.util.ArrayList;
import java.util.List;

public class Crop {
    private final int CAPACITY = 8;

    private List<Vegetable> vegetableSeeded;

    public Crop() {
        this.vegetableSeeded = new ArrayList<>();
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public List<Vegetable> getVegetableSeeded() {
        return vegetableSeeded;
    }

    public synchronized void addNewVegetable(Vegetable newVegetable) {
        while (vegetableSeeded.size() == CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        vegetableSeeded.add(newVegetable);
        notifyAll();
    }

    public synchronized void dropVegetable(Vegetable vegetable) {
        while (vegetableSeeded.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        vegetableSeeded.remove(vegetable);
        notifyAll();
    }

}
