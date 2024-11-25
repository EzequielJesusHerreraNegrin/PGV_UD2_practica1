package com.salesianoslacuesta.threads;

public class Farmer extends Thread {

    private String name = "";
    private int vegetableToSeed = 0;

    public Farmer(String name, int vegetableToSeed) {
        this.name = name;
        this.vegetableToSeed = vegetableToSeed;
    }

    public void seed() {
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
