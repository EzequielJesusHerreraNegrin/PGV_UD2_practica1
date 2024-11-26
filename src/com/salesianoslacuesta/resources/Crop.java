package com.salesianoslacuesta.resources;

import java.util.ArrayList;
import java.util.List;

public class Crop {
    private final int CAPACITY = 8;
    
    private List<Vegetable> vegetableSeeded;
    
    public Crop() {
        this.vegetableSeeded = new ArrayList<>();;
    }

    

    public List<Vegetable> getVegetableSeeded() {
        return vegetableSeeded;
    }

    public synchronized void addNewVegetable(Vegetable newVegetable) {
        if (vegetableSeeded.size() < CAPACITY) {
            vegetableSeeded.add(newVegetable);  
        } else {
            System.out.println("la lista está llena");
        }
    }
    



}
