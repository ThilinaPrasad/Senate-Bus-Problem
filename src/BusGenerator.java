/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author thili
 */
public class BusGenerator extends Thread{

    // Random object for generate random float value for the exponential time calculation
    Random random;

    // Arrival time mean (20 min)
    double arrivalIntervel;

    // Shared resources holder for threads
    Resources resources;

    // Constructor for BusGenerator Thread
    public BusGenerator(Resources resources) {
         this.random = new Random();
         this.arrivalIntervel = 20 * 60 * 1000;
         this.resources = resources;
    }


    // BusGenerator thread run method for create Rider thread with exponentially distributed time intervals
    @Override
    public void run() {
        int busId = 1;
        while (true) {
            try {
            Thread.sleep(getExponentiallyDistributedBusInterArrivalTime());
            new Bus(this.resources, busId).start();
            busId++;
            } catch (InterruptedException ex) {
                
            }
        }
        
    }

    // Exponentially distributed time interval generator with statistical approach
    public long getExponentiallyDistributedBusInterArrivalTime() {
        double lambda = 1 / this.arrivalIntervel;
        return Math.round(-Math.log(1 - this.random.nextFloat()) / lambda);
    }
    
}
