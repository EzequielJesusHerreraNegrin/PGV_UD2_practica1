package com.salesianoslacuesta.resources;

import java.util.ArrayList;
import java.util.List;

public class Crop {
    private final int CAPACITY = 8;
    private List<Vegetable> vegetableSeeded = new ArrayList<>();
    

    public List<Vegetable> getVegetableSeeded() {
        return vegetableSeeded;
    }

    public void addNewVegetable(Vegetable newVegetable) {
        if (vegetableSeeded.size() <= CAPACITY) {
            vegetableSeeded.add(newVegetable);
            
        }
    }
    



}
