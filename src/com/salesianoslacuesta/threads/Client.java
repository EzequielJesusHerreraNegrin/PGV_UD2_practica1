package com.salesianoslacuesta.threads;

import com.salesianoslacuesta.resources.Crop;
import com.salesianoslacuesta.resources.Vegetable;

public class Client extends Thread {

    Vegetable vegetable;
    private Crop crop;
    private String name = "";
    private int vegetableToEat = 0;

    public Client(String name, int vegetableToEat, Crop crop) {
        this.name = name;
        this.vegetableToEat = vegetableToEat;
        this.crop = crop;
    }

    @Override
    public void run() {
        for (int i = 0; i < vegetableToEat; i++) {
            try {

                synchronized (crop) {
                    while (crop.getVegetableSeeded().isEmpty()) {
                        System.out.println("No hay");
                        crop.wait();
                    }
                    Vegetable vegetable = crop.getVegetableSeeded().get(crop.getVegetableSeeded().size() - 1);
                    Thread.sleep(vegetable.getCooldown());
                    this.crop.dropVegetable(vegetable);
                    System.out.println(this.name + " ya ha consumido el vegetal " + vegetable.getVegetable());

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Se consumieron todos los vegetales");
    }

}
